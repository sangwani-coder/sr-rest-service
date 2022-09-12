/* 
 * ## CLASS
 * RecipeController - @RestController class that 
 *      indicates that the data returned by each method will 
 *      be written straight into the response body instead of rendering a template.
 * 
 * ### ROUTES and METHODS
 * all(): GET /recipes route method that gets all Recipes in the database.
 * 
 * newRecipe(): POST /recipe/ route method that creats a new Recipe resource.
 * 
 * one(): GET /recipes/{id} route method that gets one item matching the id.
 * 
 * replaceRecipe(): PUT /repipes/{id} route method that updates a recipe with id
 *      if exists otherwise creates a new Recipe.
 * 
 * deleteRecipe(): DELETE /recipes/{id} delete a Recipe matching id.
 */

package tech.zyambo.srapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.action.NewRuleAction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class RecipeController {

    private final RecipeRepository repository;

    RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    // Base URL
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    ArrayList<String> base(){
    ArrayList<String> endpoints = new ArrayList<>();
    endpoints.add("Resources");
    return endpoints; 
}

    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.OK)
    List<Recipe> all() {
        return repository.findAll();
    }

    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    Recipe newRecipe(@RequestBody Recipe newRecipe) {
        return repository.save(newRecipe);
    }
    
    @GetMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    Recipe one(@PathVariable Integer id) {
        return repository.findById(id)
        .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @PutMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Integer id) {
        
        return repository.findById(id)
        .map(Recipe -> {
            Recipe.setName(newRecipe.getName());
            Recipe.setCreator(newRecipe.getCreator());
            Recipe.seteditedAt(newRecipe.geteditedAt());
            Recipe.setDescription(newRecipe.getDescription());
            Recipe.setCountry(newRecipe.getCountry());
            Recipe.setPrep(newRecipe.getPrep());
            Recipe.setCook(newRecipe.getCook());
            Recipe.setServings(newRecipe.getServings());
            return repository.save(Recipe);
        })
        .orElseGet(() -> {
            newRecipe.setId(id);
            return repository.save(newRecipe);
        });
    }

    @DeleteMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRecipe(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}