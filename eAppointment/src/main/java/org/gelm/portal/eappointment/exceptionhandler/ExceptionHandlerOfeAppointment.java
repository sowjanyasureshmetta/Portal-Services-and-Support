package org.gelm.portal.eappointment.exceptionhandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ExceptionHandlerOfeAppointment implements ErrorController{

	@RequestMapping(value = {"/error"})
	public String handleError(HttpServletRequest request) {
		String errorCode=(String)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(Integer.parseInt(errorCode)==HttpStatus.NOT_FOUND.value())
		return "404";
		else if(Integer.parseInt(errorCode)==HttpStatus.INTERNAL_SERVER_ERROR.value())
		return "500";
		else
		return "error";	
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

	
	
}
