package org.gelm.portal.emovement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gelm.portal.emovement.vo.Agent;
import org.springframework.jdbc.core.RowMapper;

public class AgentMapper implements RowMapper<Agent> 
{

	@Override
	public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
		Agent agent =new Agent();
		agent.setAgentNo(rs.getString("agent_no"));
		agent.setAgentName(rs.getString("agent_name"));
		agent.setAgentGender(rs.getString("agent_gender"));
		
		agent.setAgentNric(rs.getString("agent_nric"));
		agent.setAgentMobile(rs.getString("agent_mobile"));
		agent.setAgentDob(rs.getString("agent_dob"));
		
		return agent;
	}
	

}
