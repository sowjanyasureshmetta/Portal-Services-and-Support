package org.gelm.portal.epromotion.boot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class BootofePromotion implements ApplicationRunner,CommandLineRunner{

	private static final Logger ePromotionLogger=(Logger) LogManager.getLogger(BootofePromotion.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootofePromotion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ePromotionLogger.info("This is a Command Line Runner after start up of Boot Application");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ePromotionLogger.info("This is a Application Runner after start up of Boot Application");
	}
	
}
