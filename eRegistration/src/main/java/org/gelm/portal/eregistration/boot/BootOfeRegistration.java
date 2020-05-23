package org.gelm.portal.eregistration.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
@PropertySource(value = {"application.properties"},ignoreResourceNotFound = false)
public class BootOfeRegistration {

	public static void main(String[] args) {
		SpringApplication.run(BootOfeRegistration.class, args);
	}
}
