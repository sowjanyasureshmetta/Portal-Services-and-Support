package org.gelm.portal.onlineenquiry.xml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Policy_XML {

	private String policyNo;
	
	@XmlElement
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	
	
}
