package org.gelm.portal.eworkflow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POLICY")
public class Policy {
	
	@Id
	@Column(name = "POLICY_NO")
	private String policyNo;
	@Column(name = "POLICY_HOLDER_NAME")
	private String policyHolderName;
	@Column(name = "LIFE_ASSURED_NAME")
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
