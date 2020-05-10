package org.gelm.portal.epromotion.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerOfePromotion {

	@GetMapping(value = {"/welcome"})
	public String welcome() {
		return "welcome ePromotion";
	}
	
}
