package org.gelm.portal.onlineenquiry.jms.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.gelm.portal.onlineenquiry.xml.model.Policy_XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PolicyEnquiryJMSConfiguration {
	@Value("${spring.activemq.broker-url}")
	private String brokerURL;
	@Value("${spring.activemq.user}")
	private String userName;
	@Value("${spring.activemq.password}")
	private String password;
	
	@Bean
	public ActiveMQConnectionFactory configureConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerURL);
		connectionFactory.setUserName(userName);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}
	@Bean
	public JmsTemplate configureJMSTemplate() {
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(configureConnectionFactory());
		jmsTemplate.setDefaultDestinationName("GELM_QUEUE");
		jmsTemplate.setMessageConverter(configureXMLConverter());
		return jmsTemplate;
	}
	@Bean
	public MarshallingMessageConverter configureXMLConverter() {
		MarshallingMessageConverter xmlConverter=new MarshallingMessageConverter();
		xmlConverter.setMarshaller(configureJaxbMarshaller());
		xmlConverter.setUnmarshaller(configureJaxbMarshaller());
		xmlConverter.setTargetType(MessageType.TEXT);
		return xmlConverter;
	}
	@Bean
	public Jaxb2Marshaller configureJaxbMarshaller() {
		 	Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		    jaxb2Marshaller.setClassesToBeBound(Policy_XML.class);
		    Map<String,Object> map = new HashMap<>();
		    map.put("jaxb.formatted.output", true);
		    jaxb2Marshaller.setMarshallerProperties(map);
		    return jaxb2Marshaller;
	}
	
}
