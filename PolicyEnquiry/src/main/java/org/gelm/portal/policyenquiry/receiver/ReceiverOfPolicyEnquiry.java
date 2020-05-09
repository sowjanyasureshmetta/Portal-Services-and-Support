package org.gelm.portal.policyenquiry.receiver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.transform.stream.StreamSource;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class ReceiverOfPolicyEnquiry {

	@JmsListener(destination = "GELM_QUEUE")
	@SendTo("GELM_QUEUE")
	public Message receiveMessage(TextMessage textMsg,Session session) throws JMSException, IOException {
		return (ObjectMessage)session.createObjectMessage(xmlToObject("policy.xml"));
	}
	
	//Converts XML to Java Object
    public Serializable xmlToObject(String fileName) throws IOException {
    	
        Jaxb2Marshaller unmarshaller=new Jaxb2Marshaller();
        unmarshaller.setPackagesToScan("org.gelm.portal.policyenquiry.bean");
      
    	
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            return (Serializable) unmarshaller.unmarshal(new StreamSource(fis));
        } finally {
        	fis.close();
        }
    }
}
