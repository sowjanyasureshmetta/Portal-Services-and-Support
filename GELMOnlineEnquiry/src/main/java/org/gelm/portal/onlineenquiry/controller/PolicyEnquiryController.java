package org.gelm.portal.onlineenquiry.controller;

import org.gelm.portal.onlineenquiry.model.Policy;
import org.gelm.portal.onlineenquiry.service.PolicyEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PolicyEnquiryController {
	
	@Autowired
	private PolicyEnquiryService enquiryService;
	
	@ModelAttribute
	public void setPolicyEnquiryHeader(Model model) {
		model.addAttribute("header", "GELM-Policy Enquiry");
	}
	
	@RequestMapping(value = {"/policyenquiry"},method = RequestMethod.GET)
	public ModelAndView displayPolicyEnquiryPage(@ModelAttribute("policy")Policy policy) {
		return new ModelAndView("PolicyEnquiry");
	}
	@RequestMapping(value = {"/submitpolicyenquiry"},method = RequestMethod.POST)
	public ModelAndView submitPolicyEnquiry(@ModelAttribute("policy")Policy policy,Model model) {
		Policy policyResponse=(Policy)enquiryService.sendPolicyRequest(policy);
		model.addAttribute("policyresponse", policyResponse);
		return new ModelAndView("PolicyDetails");
	}
}
