package org.gelm.portal.eappointment.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class TestBootOfwebeAppointment {

	public static void main(String[] args) {
		SpringApplication.run(TestBootOfwebeAppointment.class, args);
	}
	
}
