package org.gelm.portal.eappointment.test;

import org.gelm.portal.eappointment.entity.Agent;
import org.gelm.portal.eappointment.repository.AgentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = {Agent.class})
@EnableJpaRepositories(basePackageClasses = {AgentRepository.class})
public class TestBootOfDataJpaeAppointment {

	public static void main(String[] args) {
		SpringApplication.run(TestBootOfDataJpaeAppointment.class, args);
	}
	
}
