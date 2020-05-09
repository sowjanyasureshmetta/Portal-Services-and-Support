package org.gelm.portal.eworkflow.controller;

import java.util.List;

import org.gelm.portal.eworkflow.entity.Policy;
import org.gelm.portal.eworkflow.service.ServiceOfeWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOfeWorkflow {

	@Autowired
	private ServiceOfeWorkflow eWorkflowService;
	
	@GetMapping(value = {"/{policyNo}"})
	public Policy getPolicyDetails(@PathVariable("policyNo") String policyNo) {
		return eWorkflowService.getPolicyDetails(policyNo);
	}
	
	@GetMapping(value = {"/policydetails"})
	public List<Policy> getAllPolicyDetails(){
		return eWorkflowService.getAllPolicyDetails();
	}
	
}
