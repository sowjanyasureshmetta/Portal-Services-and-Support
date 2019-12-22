package org.gelm.portal.onlineenquiry.service;

import javax.jms.JMSException;
import javax.jms.Message;

import org.gelm.portal.onlineenquiry.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

@Service
public class PolicyEnquiryService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public Policy sendPolicyRequest(Policy policyRequest){
		jmsTemplate.convertAndSend("GELM_QUEUE",policyRequest,new MessagePostProcessor() {
			
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				message.setJMSMessageID("GELM-001"); 
				return message; 
			}
		});
		
		return (Policy)jmsTemplate.receiveSelectedAndConvert("GELM_QUEUE", "GELM-001");
	}
}
