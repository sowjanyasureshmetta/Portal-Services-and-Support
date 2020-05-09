package org.gelm.portal.policyenquiry.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "policy")
@XmlAccessorType(XmlAccessType.NONE)
public class Policy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "policy_no")
	private String policyNo;
	@XmlElement(name = "policy_holder_name")
	private String policyHolderName;
	@XmlElement(name = "life_assured_name")
	private String lifeAssuredName;
	
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public String getLifeAssuredName() {
		return lifeAssuredName;
	}
	public void setLifeAssuredName(String lifeAssuredName) {
		this.lifeAssuredName = lifeAssuredName;
	}

	
	
}
