package org.gelm.portal.eappointment.repository;

import org.gelm.portal.eappointment.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String> {

}
