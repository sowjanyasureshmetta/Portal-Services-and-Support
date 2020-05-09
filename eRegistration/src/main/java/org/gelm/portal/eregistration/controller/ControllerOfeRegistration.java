package org.gelm.portal.eregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerOfeRegistration {

	@GetMapping(value = {"/index","/welcome"})
	public ModelAndView configureIndexPageOfeRegistraion()
	{
		return new ModelAndView("index");
	}
	
}
