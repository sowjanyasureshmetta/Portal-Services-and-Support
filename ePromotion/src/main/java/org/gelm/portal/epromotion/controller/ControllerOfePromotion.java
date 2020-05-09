package org.gelm.portal.epromotion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerOfePromotion {
	@GetMapping(value = {"/index"})
	public ModelAndView indexPage() {
		return new ModelAndView("index");
	}
	
}
