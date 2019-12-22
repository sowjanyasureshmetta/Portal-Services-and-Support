package org.gelm.portal.onlineenquiry.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GELM-POLICY")
public class Policy {

	@XmlElement(name = "POLICY NO")
	private String policyNo;
	
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
}
