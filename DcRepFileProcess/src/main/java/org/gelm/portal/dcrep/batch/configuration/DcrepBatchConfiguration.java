package org.gelm.portal.dcrep.batch.configuration;

import javax.sql.DataSource;

import org.gelm.portal.dcrep.batch.model.Agent;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class DcrepBatchConfiguration {

	@Autowired
	private JobBuilderFactory dcRepJobBuilderFactory;
	@Autowired
	private StepBuilderFactory dcRepStepBuilderFactory;
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public ItemReader<Agent> getItemReaderOfDcRepBatch(){
		FlatFileItemReader<Agent> dcRepFileItemReader=new FlatFileItemReader<Agent>();
		dcRepFileItemReader.setResource(new FileSystemResource("src/main/resources/agent.csv"));
		dcRepFileItemReader.setLinesToSkip(1);
		
		BeanWrapperFieldSetMapper<Agent> fieldMapper=new BeanWrapperFieldSetMapper<Agent>();
		/*
		 * Map map=new HashMap<>(); map.put(Date.class, new CustomDateEditor());
		 * fieldMapper.setCustomEditors(map);
		 */
		fieldMapper.setTargetType(Agent.class);
		
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer("|");
		lineTokenizer.setNames("AgentNo","AgentName","AgentNric","AgentMobile","AgentCreationDate");
		
		DefaultLineMapper<Agent> lineMapper=new DefaultLineMapper<Agent>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldMapper);
		
		dcRepFileItemReader.setLineMapper(lineMapper);
		
		return dcRepFileItemReader;
	}
	
	@Bean
	public ItemWriter<Agent> getItemWriterForDcRepBatch(){
		JdbcBatchItemWriter<Agent> dcRepFileItemWriter=new JdbcBatchItemWriter<Agent>();
		dcRepFileItemWriter.setDataSource(dataSource);
		dcRepFileItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Agent>());
		dcRepFileItemWriter.setSql("insert into ep_app_agt values(:agentNo,:agentName,:agentNric,:agentMobile,:agentCreationDate)");
		return dcRepFileItemWriter;
	}
	@Bean
	public Step configureDcRepStep() {
	
		return dcRepStepBuilderFactory.get("dcrep_file_generation_step")
				.<Agent,Agent>chunk(5)
				.reader(getItemReaderOfDcRepBatch())
				.writer(getItemWriterForDcRepBatch())
				.build();
	}
	@Bean
	public Job cofigureDcRepJob() {
		return dcRepJobBuilderFactory
				.get("dcrep_file_generation_job")
				.incrementer(new RunIdIncrementer())
				.flow(configureDcRepStep())
				.end()
				.build();
	}
	
}
