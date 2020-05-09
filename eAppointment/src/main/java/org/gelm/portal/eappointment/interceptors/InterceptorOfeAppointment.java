package org.gelm.portal.eappointment.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

@Component
public class InterceptorOfeAppointment implements HandlerInterceptor{

	private static Logger interceptorLogger=(Logger) LoggerFactory.getLogger(InterceptorOfeAppointment.class);
	
      @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    		throws Exception {
    	interceptorLogger.info("Pre Handle of eAppointment Interceptor");  
    	return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	interceptorLogger.info("After Completion of eAppointment Interceptor");
    	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }  
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		interceptorLogger.info("Post Handle of eAppointment Interceptor");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
