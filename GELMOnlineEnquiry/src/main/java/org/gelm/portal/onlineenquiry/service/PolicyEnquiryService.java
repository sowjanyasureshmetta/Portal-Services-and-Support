package org.gelm.portal.onlineenquiry.service;

import javax.jms.JMSException;
import javax.jms.Message;

import org.gelm.portal.onlineenquiry.xml.model.Policy_XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

@Service
public class PolicyEnquiryService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public Policy_XML sendPolicyRequest(Policy_XML policyRequest){
		
		jmsTemplate.convertAndSend("GELM_QUEUE",policyRequest,new MessagePostProcessor() {
			
			@Override
			public Message postProcessMessage(Message message) throws JMSException {
				message.setJMSMessageID("GELM"); 
				return message; 
			}
		});
		
		return (Policy_XML)jmsTemplate.receiveAndConvert("GELM_QUEUE");
	}
}
