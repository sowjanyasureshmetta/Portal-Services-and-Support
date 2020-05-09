package org.gelm.portal.policyenqiury.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@PropertySource(value = {"application-test.properties"})
public class ConfigurationOfPolicyEnquiry {
	
	@Value("${spring.activemq.broker-url}")
	private String brokerURL;
	@Value("${spring.activemq.user}")
	private String userName;
	@Value("${spring.activemq.password}")
	private String password;
	
	@Bean
	public ConnectionFactory configureConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerURL);
		connectionFactory.setUserName(userName);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}
	@Bean
	public JmsTemplate configureJmsTemplate() {
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(configureConnectionFactory()); 
		return jmsTemplate;
	}
	@Bean
	public DefaultJmsListenerContainerFactory configureListenerFactory() {
		DefaultJmsListenerContainerFactory listenerFactory=new DefaultJmsListenerContainerFactory();
		listenerFactory.setConnectionFactory(configureConnectionFactory());
		return listenerFactory;
	}
	@Bean
	public Jaxb2Marshaller configureMarshallerAndUnMarshaller() {
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		marshaller.setPackagesToScan("org.gelm.portal.policyenquiry.bean");
		Map<String,Object> properties=new HashMap<String,Object>();
		properties.put("jaxb.formatted.output", true);
		marshaller.setMarshallerProperties(properties);
		return marshaller;
	}
}
