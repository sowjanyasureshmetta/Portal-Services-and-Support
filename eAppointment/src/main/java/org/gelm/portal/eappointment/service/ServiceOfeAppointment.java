package org.gelm.portal.eappointment.service;

import java.util.List;
import java.util.Optional;

import org.gelm.portal.eappointment.entity.Agent;
import org.gelm.portal.eappointment.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfeAppointment {

	@Autowired
	private AgentRepository agentRepository;
	
	public List<Agent> getAllAgents(){
		return agentRepository.findAll();
	}
	public Optional<Agent> getAgentDetailsById(String id){
		return agentRepository.findById(id);
	}
	public void addAgent(Agent agent) {
		agentRepository.save(agent);
	}
}
