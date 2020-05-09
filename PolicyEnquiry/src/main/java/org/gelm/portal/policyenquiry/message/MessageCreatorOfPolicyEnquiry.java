package org.gelm.portal.policyenquiry.message;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.transform.stream.StreamResult;

import org.gelm.portal.policyenquiry.bean.Policy;
import org.springframework.jms.core.MessageCreator;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
public class MessageCreatorOfPolicyEnquiry implements MessageCreator{

	@Override
	public Message createMessage(Session session) {
		
		TextMessage msg=null;
		
		Policy policy=new Policy();
		policy.setPolicyNo("1023456789");
		policy.setPolicyHolderName("Suresh");
		policy.setLifeAssuredName("Leela krishna");
		try {
			objectToXML("policy.xml", policy);
			try {
				msg= (TextMessage)session.createTextMessage(readXMLFileAsString("policy.xml"));
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	//Converts Object to XML file
    public void objectToXML(String fileName, Object graph) throws IOException {
        FileOutputStream fos = null;
        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		marshaller.setPackagesToScan("org.gelm.portal.policyenquiry.bean");
		Map<String,Object> properties=new HashMap<String,Object>();
		properties.put("jaxb.formatted.output", true);
		marshaller.setMarshallerProperties(properties);
        try {
            fos = new FileOutputStream(fileName);
            marshaller.marshal(graph, new StreamResult(fos));
        } finally {
        	fos.close();
        }
    }
    public String readXMLFileAsString(String fileName) {
    	StringBuffer output = new StringBuffer();
        String st;
    	try {
            BufferedReader in
                    = new BufferedReader(new FileReader(fileName));
            while ((st=in.readLine()) != null) {
                     output.append(st);
            }
            in.close();
        }
        catch (Exception fx) {
            System.out.println("Exception " + fx.toString());
        }
    	return output.toString();
    }
	

}
