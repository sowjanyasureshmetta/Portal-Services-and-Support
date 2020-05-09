package org.gelm.portal.eappointment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
	@Id
	@Column(name = "agent_no")
	private String agentNo;
	@Column(name = "agent_name")
	private String agentName;
	@Column(name = "agent_gender")
	private String agentGender;
	@Column(name = "agent_nric")
	private String agentNric;
	@Column(name = "agent_mobile")
	private String agentMobile;
	@Column(name = "agent_dob")
	private String agentDob;
	
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentGender() {
		return agentGender;
	}
	public void setAgentGender(String agentGender) {
		this.agentGender = agentGender;
	}
	public String getAgentNric() {
		return agentNric;
	}
	public void setAgentNric(String agentNric) {
		this.agentNric = agentNric;
	}
	public String getAgentMobile() {
		return agentMobile;
	}
	public void setAgentMobile(String agentMobile) {
		this.agentMobile = agentMobile;
	}
	public String getAgentDob() {
		return agentDob;
	}
	public void setAgentDob(String agentDob) {
		this.agentDob = agentDob;
	}
}
