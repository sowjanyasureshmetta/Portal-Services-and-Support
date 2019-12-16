package org.gelm.portal.onlineenquiry.controller;

import org.gelm.portal.onlineenquiry.model.Policy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PolicyEnquiryController {
	
	@ModelAttribute
	public void setPolicyEnquiryHeader(Model model) {
		model.addAttribute("header", "GELM-Policy Enquiry");
	}
	
	@RequestMapping(value = {"/policyenquiry"},method = RequestMethod.GET)
	public ModelAndView displayPolicyEnquiryPage(@ModelAttribute("policy")Policy policy) {
		return new ModelAndView("PolicyDetails");
	}
	
}
