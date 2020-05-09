package org.gelm.portal.eappointment.boot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ch.qos.logback.classic.Logger;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
@EnableJpaRepositories(basePackages = {"org.gelm.portal.*"})
@EntityScan(basePackages = {"org.gelm.portal.*"})
public class BootOfeAppointment extends SpringBootServletInitializer implements ApplicationRunner,CommandLineRunner{

	private static final Logger eappointmentLogger=(Logger) LoggerFactory.getLogger(BootOfeAppointment.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootOfeAppointment.class, args); 
	}

	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(BootOfeAppointment.class);
	  }
	
	@Override
	public void run(String... args) throws Exception {
		eappointmentLogger.info("Command Line Runner");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		eappointmentLogger.info("Application Runner");
	}
	
}
