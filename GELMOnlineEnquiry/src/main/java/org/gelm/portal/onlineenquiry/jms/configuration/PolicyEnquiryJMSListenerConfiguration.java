package org.gelm.portal.onlineenquiry.jms.configuration;

import org.gelm.portal.onlineenquiry.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class PolicyEnquiryJMSListenerConfiguration {

	@Autowired
	private JmsTemplate jmsTemplate;
	public Policy receivePolicy() {
		return (Policy)jmsTemplate.receiveSelectedAndConvert("GELM_QUEUE", "GELM");	
	}
	
}
