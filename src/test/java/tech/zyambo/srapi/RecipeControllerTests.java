package tech.zyambo.srapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import tech.zyambo.srapi.controllers.RecipeController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipeControllerTests {

	// Test whether the context creates the RecipeController	
	@Autowired
    private RecipeController recipeController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(recipeController).isNotNull();
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
                = "{\"result:\":{\"omnivore\":\"/srapi/v1/recipes/omnivore\",\"vegetarian\":\"/srapi/v1/recipes/vegetarian\",\"vegan\":\"/srapi/v1/recipes/vegan\"}}";
        
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/srapi/v1/recipes",
				String.class)).contains(expected);
	}
}
