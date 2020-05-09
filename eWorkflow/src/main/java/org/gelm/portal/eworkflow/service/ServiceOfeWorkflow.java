package org.gelm.portal.eworkflow.service;

import java.util.List;

import org.gelm.portal.eworkflow.entity.Policy;
import org.gelm.portal.eworkflow.repository.RepositoryOfeWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfeWorkflow {

	@Autowired
	private RepositoryOfeWorkflow eWorkflowRepo;
	
	public Policy getPolicyDetails(String policyNo) {
		return eWorkflowRepo.getPolicyDetails(policyNo);
	}
	
	public List<Policy> getAllPolicyDetails(){
		return eWorkflowRepo.findAll();
	}
	
}
