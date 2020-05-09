package org.gelm.portal.emovement.boot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class BootOfeMovement implements ApplicationRunner{

	private static final Logger logger=(Logger) LoggerFactory.getLogger(BootOfeMovement.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootOfeMovement.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Application runner");
	}
	
}
