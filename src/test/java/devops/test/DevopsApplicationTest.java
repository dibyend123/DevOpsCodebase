package devops.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import com.devops.action.SpringBootWebApplication;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
@SpringBootTest
public class DevopsApplicationTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	
	@Before
	public void setup() {
        	this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	@Test
	public void checkWelcomePage() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/").accept(MediaType.TEXT_PLAIN))
				.andExpect(content().string("This is the Devops Calculator"));
				
	}

	@Test
	public void checkadd() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/add?a=10&b=30").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/add?a=10&b=30").accept(MediaType.TEXT_PLAIN))
				.andExpect(content().string("40"));
				
	}

	@Test
	public void checkminus() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/minus?a=50&b=10").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/minus?a=50&b=10").accept(MediaType.TEXT_PLAIN))
				.andExpect(content().string("40"));
				
	}

	@Test
	public void checkmultiply() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/multiply?a=50&b=10").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/multiply?a=50&b=10").accept(MediaType.TEXT_PLAIN))
				.andExpect(content().string("500"));
				
	}

	@Test
	public void checkdivide() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/divide?a=50&b=10").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk());
		mockMvc.perform(MockMvcRequestBuilders.get("/DevOpsCal/divide?a=50&b=10").accept(MediaType.TEXT_PLAIN))
				.andExpect(content().string("5.0"));
				
	}

}
