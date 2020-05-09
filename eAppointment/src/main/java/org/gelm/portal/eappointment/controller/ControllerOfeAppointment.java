package org.gelm.portal.eappointment.controller;

import org.gelm.portal.eappointment.entity.Agent;
import org.gelm.portal.eappointment.service.ServiceOfeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerOfeAppointment {

	@Autowired
	private ServiceOfeAppointment eAppointmentService;
	
	@GetMapping(value = {"/agent"})
	public ModelAndView configureWelcomePage(@ModelAttribute("agentdetails") Agent agent) {
		return new ModelAndView("welcome");
	}
	@PostMapping(value = {"/addagent"})
	public ModelAndView addAgent(@ModelAttribute("agentdetails") Agent agent) {
		eAppointmentService.addAgent(agent);
		return new ModelAndView("Details");
	} 
}
