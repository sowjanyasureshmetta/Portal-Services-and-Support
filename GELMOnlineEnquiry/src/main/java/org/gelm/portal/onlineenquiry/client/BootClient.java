package org.gelm.portal.onlineenquiry.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class BootClient {

	public static void main(String[] args) {
		SpringApplication.run(BootClient.class, args);
	}

}
