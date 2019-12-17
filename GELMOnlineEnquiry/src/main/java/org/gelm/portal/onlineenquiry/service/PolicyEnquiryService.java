package org.gelm.portal.onlineenquiry.service;

import org.gelm.portal.onlineenquiry.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PolicyEnquiryService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendPolicyRequest(Policy policyRequest){
		jmsTemplate.convertAndSend(policyRequest);
	}
}
