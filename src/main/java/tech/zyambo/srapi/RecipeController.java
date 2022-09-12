package tech.zyambo.srapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class RecipeController {

    private final RecipeRepository repository;

    RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/recipes")
    List<Recipe> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/recipes")
    Recipe newRecipe(@RequestBody Recipe newRecipe) {
        return repository.save(newRecipe);
    }

    // Single item
    
    @GetMapping("/recipes/{id}")
    Recipe one(@PathVariable Integer id) {
        
        return repository.findById(id)
        .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @PutMapping("/recipes/{id}")
    Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Integer id) {
        
        return repository.findById(id)
        .map(Recipe -> {
            Recipe.setName(newRecipe.getName());
            Recipe.setCreator(newRecipe.getCreator());
            return repository.save(Recipe);
        })
        .orElseGet(() -> {
            newRecipe.setId(id);
            return repository.save(newRecipe);
        });
    }

    @DeleteMapping("/recipes/{id}")
    void deleteRecipe(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}