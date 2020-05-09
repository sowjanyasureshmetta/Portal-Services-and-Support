package org.gelm.portal.eworkflow.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class BootOfeWorkflow {

	public static void main(String[] args) {
		SpringApplication.run(BootOfeWorkflow.class, args);
	}
	
}
