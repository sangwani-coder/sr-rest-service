package tech.zyambo.srapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import tech.zyambo.srapi.controllers.VegetarianController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VegetarianControllerTests {

	// Test whether the context creates the Controller	
	@Autowired
    private VegetarianController vegetarianController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(vegetarianController).isNotNull();
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
                = "{\"result:\":{\"lunch\":\"/srapi/v1/recipes/vegetarian/lh\",\"breakfast\":\"/srapi/v1/recipes/vegetarian/bf\",\"dinner\":\"/srapi/v1/recipes/vegetarian/dr\"}}";
        
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/srapi/v1/recipes/vegetarian",
				String.class)).contains(expected);
	}
}
