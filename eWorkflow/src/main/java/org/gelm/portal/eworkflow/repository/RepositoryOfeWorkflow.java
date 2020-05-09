package org.gelm.portal.eworkflow.repository;

import org.gelm.portal.eworkflow.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOfeWorkflow extends JpaRepository<Policy, String>{

	public Policy getPolicyDetails(String policyNo);
	
}
