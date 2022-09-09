package tech.zyambo.srapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import tech.zyambo.srapi.controllers.VeganController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VeganControllerTests {

	// Test whether the context creates the Controller	
	@Autowired
    private VeganController veganController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(veganController).isNotNull();
    } 

	@LocalServerPort
	private int port;

	// Test the Base URL
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void baseURLShouldReturnAllResources() throws Exception {
        // Tests that the Base URL returns all resources
        String expected 
                = "{\"result:\":{\"lunch\":\"/srapi/v1/recipes/vegan/lh\",\"breakfast\":\"/srapi/v1/recipes/vegan/bf\",\"dinner\":\"/srapi/v1/recipes/vegan/dr\"}}";
        
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/srapi/v1/recipes/vegan",
				String.class)).contains(expected);
	}
}
