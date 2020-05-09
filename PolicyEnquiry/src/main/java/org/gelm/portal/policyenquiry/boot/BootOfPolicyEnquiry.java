package org.gelm.portal.policyenquiry.boot;

import javax.jms.ObjectMessage;

import org.gelm.portal.policyenquiry.bean.Policy;
import org.gelm.portal.policyenquiry.message.MessageCreatorOfPolicyEnquiry;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import ch.qos.logback.classic.Logger;

@SpringBootApplication(scanBasePackages = {"org.gelm.portal.*"})
public class BootOfPolicyEnquiry implements CommandLineRunner,ApplicationRunner{
 
	private static final Logger enquiryLogger=(Logger) LoggerFactory.getLogger(BootOfPolicyEnquiry.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BootOfPolicyEnquiry.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		enquiryLogger.info("Application Ruuner");
	}

	@Override
	public void run(String... args) throws Exception {
		enquiryLogger.info("Command Line Ruuner");
		ObjectMessage message=
		(ObjectMessage)jmsTemplate.sendAndReceive("GELM_QUEUE", new MessageCreatorOfPolicyEnquiry());
		Policy policy=(Policy)message.getObject();
		enquiryLogger.info("This is Message from GELM_QUEUE : "
				+ ""+policy.getPolicyNo()+"\t"
				+ ""+policy.getPolicyHolderName()+"\t"
				+ ""+policy.getLifeAssuredName()+"\t");
	}
	
		
}
