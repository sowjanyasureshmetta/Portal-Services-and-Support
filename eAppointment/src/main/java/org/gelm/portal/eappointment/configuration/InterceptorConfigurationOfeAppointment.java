package org.gelm.portal.eappointment.configuration;

import org.gelm.portal.eappointment.interceptors.InterceptorOfeAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurationOfeAppointment implements WebMvcConfigurer {
 
		@Autowired
		private InterceptorOfeAppointment eAppointmentInterceptor;
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			// TODO Auto-generated method stub
			registry.addInterceptor(eAppointmentInterceptor);
		}
}
