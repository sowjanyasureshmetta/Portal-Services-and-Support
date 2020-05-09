package org.gelm.portal.eappointment.restcontroller;

import java.util.List;
import java.util.Optional;

import org.gelm.portal.eappointment.entity.Agent;
import org.gelm.portal.eappointment.service.ServiceOfeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerOfeAppointment {

	@Autowired
	private ServiceOfeAppointment agentService;
	
	@GetMapping(value = {"/welcome"})
	public String configWelcomeMessage() {
		return "Welcome to eAppointment process";
	}
	@GetMapping(value = {"/allagents"})
	public List<Agent> getAllAgents(){
		return agentService.getAllAgents();
	}
	@GetMapping(value = {"/agentbasedid/{agentno}"})
	public Optional<Agent> getAgentDetailsById(@PathVariable("agentno")String id){
		return agentService.getAgentDetailsById(id);
	}
	
}
