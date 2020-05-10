package org.gelm.portal.eregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

@Controller
public class ControllerOfeRegistration {

	@GetMapping(value = {"/index"})
	public ModelAndView configureIndexPageOfeRegistraion()
	{
		return new ModelAndView("index");
	}
	@ResponseBody
	@ApiOperation(value = "generates the welcome content")
	@GetMapping(value = {"/welcome"})
	public String welcome() {
		return "welcome";
	}
	
}
