package tech.zyambo.srapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class RecipeController {
    
    private final RecipeRepository repository;
    
    private final RecipeModelAssembler assembler;

    RecipeController(RecipeRepository repository, RecipeModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    
    /** 
     * @return CollectionModel<EntityModel<Recipe>>
     */
    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.OK)
    CollectionModel<EntityModel<Recipe>> all() {
      
        List<EntityModel<Recipe>> recipes = repository.findAll().stream() //
            .map(assembler::toModel) //
            .collect(Collectors.toList());
      
        return CollectionModel.of(recipes, linkTo(methodOn(RecipeController.class).all()).withSelfRel());
      }

    
    /** 
     * @param newRecipe
     * @return Recipe
     */
    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    Recipe newRecipe(@RequestBody Recipe newRecipe) {
        return repository.save(newRecipe);
    }
    
    
    /** 
     * @param id
     * @return EntityModel<Recipe>
     */
    @GetMapping("/recipes/{id}")
    EntityModel<Recipe> one(@PathVariable Integer id) {

    Recipe recipe = repository.findById(id) //
        .orElseThrow(() -> new RecipeNotFoundException(id));
        
        return assembler.toModel(recipe);
    }

    
    /** 
     * @param newRecipe
     * @param id
     * @return Recipe
     */
    @PutMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Integer id) {
               
        return repository.findById(id)
        .map(Recipe -> {
            Recipe.setRecipeName(newRecipe.getRecipeName());
            Recipe.setCreator(newRecipe.getCreator());
            Recipe.seteditedAt(newRecipe.geteditedAt());
            Recipe.setDescription(newRecipe.getDescription());
            Recipe.setCountry(newRecipe.getCountry());
            Recipe.setPrep(newRecipe.getPrep());
            Recipe.setCook(newRecipe.getCook());
            Recipe.setServings(newRecipe.getServings());
            Recipe.setIngredient(newRecipe.getIngredient());
            Recipe.setCategory(newRecipe.getCategory());
            Recipe.setCookDirections(newRecipe.getCookDirections());
            Recipe.setNurition(newRecipe.getnutrients());
            return repository.save(Recipe);
        })
        .orElseGet(() -> {
            newRecipe.setId(id);
            return repository.save(newRecipe);
        });
    }

    
    /** 
     * @param id
     */
    @DeleteMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRecipe(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}