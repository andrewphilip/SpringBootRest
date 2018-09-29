package andy.rest.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import andy.rest.web.controller.LocationController;
import andy.rest.web.domain.Location;
import andy.rest.web.repo.LocationRepo;
/**
 * Ref:https://www.baeldung.com/spring-boot-testing,
 * https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/
 * https://github.com/andrewphilip/springboot-projects.git
 * @author andrew
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
public class TestLocationController {
	
	
	private static final Logger log = LoggerFactory.getLogger(TestLocationController.class);

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private LocationRepo repo;
	
	@Before
	public void setUp() {
		//this.mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testAllLocations() throws Exception {
		
		Location loc=new Location("Seoul","South Korea");
		List<Location> result=Arrays.asList(loc);
		
		Mockito.when(repo.findAll()).thenReturn(result);
		assertNotNull("Failure- mockMvc is null",mockMvc);
		mockMvc.perform(
										MockMvcRequestBuilders.get("/locations")
										.accept(MediaType.APPLICATION_JSON)
										.contentType(MediaType.APPLICATION_JSON)
										)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].city", is(loc.getCity())));
	}
}
