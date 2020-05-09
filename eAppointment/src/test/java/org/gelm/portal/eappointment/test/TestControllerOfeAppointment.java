package org.gelm.portal.eappointment.test;

import org.gelm.portal.eappointment.restcontroller.RestControllerOfeAppointment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = RestControllerOfeAppointment.class)
@ContextConfiguration(classes = TestBootOfwebeAppointment.class)
public class TestControllerOfeAppointment {

	/*
	 * @Autowired private MockMvc mockMvc;
	 */
	private MockMvc mockMvc;
	@Before
	public void initializeMockMvc() {
		mockMvc=MockMvcBuilders.standaloneSetup(new RestControllerOfeAppointment()).build();
	}
	@Test
	public void testWelcome() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/welcome"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
