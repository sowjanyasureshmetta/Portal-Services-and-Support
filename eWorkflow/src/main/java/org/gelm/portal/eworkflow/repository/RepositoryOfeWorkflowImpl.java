package org.gelm.portal.eworkflow.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gelm.portal.eworkflow.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryOfeWorkflowImpl {
		
	@Autowired
	private EntityManager eWorkflowManager;
	
	public Policy getPolicyDetails(String policyNo) {
		Query eWorkflowQuery=
		eWorkflowManager.createQuery("SELECT p FROM Policy AS p WHERE p.policyNo=:policyNo");
		eWorkflowQuery.setParameter("policyNo", policyNo);
		return (Policy) eWorkflowQuery.getSingleResult();
	}
	
}
