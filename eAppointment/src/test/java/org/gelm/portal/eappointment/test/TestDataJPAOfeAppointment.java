package org.gelm.portal.eappointment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.gelm.portal.eappointment.repository.AgentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = TestBootOfDataJpaeAppointment.class)
public class TestDataJPAOfeAppointment {

	@Autowired
	private AgentRepository agentRepository;
	@Test
	public void testDataJpaOfeAppointment() {
		assertEquals(agentRepository.findAll().size(),6);
	}
	
}
