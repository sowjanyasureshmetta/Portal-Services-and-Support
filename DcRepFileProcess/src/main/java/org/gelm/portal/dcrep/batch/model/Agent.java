package org.gelm.portal.dcrep.batch.model;

public class Agent {

	private String agentNo;
	private String agentName;
	private String agentNric;
	private String agentMobile;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    //private Date agentCreationDate;
	private String agentCreationDate;
	
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
	public String getAgentCreationDate() {
		return agentCreationDate;
	}
	public void setAgentCreationDate(String agentCreationDate) {
		this.agentCreationDate = agentCreationDate;
	}
	
}
