package br.com.onlineservice.ApiOnlineClassGestao;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest //classpath:/com/example/
@TestPropertySource(locations = "application-test.properties")
public class ConfigTest {
	
	protected MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
}
