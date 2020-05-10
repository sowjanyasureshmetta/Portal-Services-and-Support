package org.gelm.portal.eworkflow.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableJpaRepositories(basePackages = {"org.gelm.portal.*"})
@EntityScan(basePackages = {"org.gelm.portal.*"})
@EnableSwagger2
public class ConfigurationOfeWorkflow {

	@Bean
	public Docket configureDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.gelm.portal.*"))
				.build();
	}
	
}
