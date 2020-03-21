package org.gelm.portal.dcrep.batch.boot;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class DcrepBatchConfigurationBoot implements ApplicationRunner{

	@Autowired
	private JobLauncher dcRepJobLauncher;
	
	@Autowired
	private Job dcRepJob;
	
	public static void main(String[] args) {
		SpringApplication.run(DcrepBatchConfigurationBoot.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dcRepJobLauncher.run(dcRepJob,new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
	}
}
