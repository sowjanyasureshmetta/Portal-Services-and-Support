package org.gelm.portal.emovement.configuration;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.gelm.portal.emovement.mapper.AgentMapper;
import org.gelm.portal.emovement.vo.Agent;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class ConfigurationOfeMovement {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private DataSource dataSource;
	@Value("${emovement.agent.status.new}")
	private String agentStatus;
	
	@Bean
	public Job configureeMovementJob() {
		return jobBuilderFactory
		.get("emovementjob")
		.start(configureeMovementStep())
		.build();

	}
	@Bean
	public Step configureeMovementStep() {
		return stepBuilderFactory
		.get("emovementstep")
		.<Agent,Agent>chunk(10)
		.reader(configureItemReader())
		.writer(configureItemWriter())
		.build();
	}
	@Bean
	public JdbcCursorItemReader<Agent> configureItemReader(){
		JdbcCursorItemReader<Agent> itemReader =new JdbcCursorItemReader<Agent>();
		itemReader.setDataSource(dataSource);
		itemReader.setSql("select * from agent where agent_status='"+agentStatus+"'");
		itemReader.setRowMapper(new AgentMapper());
		return itemReader;
	}
	@Bean
	public FlatFileItemWriter<Agent> configureItemWriter(){
		FlatFileItemWriter<Agent> itemWriter =new FlatFileItemWriter<Agent>();
		itemWriter.setResource(new FileSystemResource("agent"+LocalDate.now()+".csv"));
		itemWriter.setLineAggregator(new DelimitedLineAggregator<Agent>() {{
		   setDelimiter(",");
		   setFieldExtractor(new BeanWrapperFieldExtractor<Agent>() {{
		    setNames(new String[] { "agentNo", "agentName", "agentGender", "agentNric", "agentMobile", "agentDob" });
		   }});
		  }});
		return itemWriter;
	}
	
}
