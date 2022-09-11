package tech.zyambo.srapi.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.zyambo.srapi.model.Recipe;
import tech.zyambo.srapi.model.service.RecipeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@RestController
// @Component
@RequestMapping(path="/srapi/v1", produces="application/json")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

     @GetMapping("/")
     @ResponseStatus(HttpStatus.OK)
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("omnivore", "/srapi/v1/recipes/omnivore");
        resUrls.put("vegan", "/srapi/v1/recipes/vegan");
        resUrls.put("vegetarian", "/srapi/v1/recipes/vegetarian");    

        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }

    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.OK)
    private List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Recipe getRecipes(@PathVariable("id") int id){
        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("/recipe/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deleteRecipes(@PathVariable("id") int id){
        recipeService.delete(id);
    }

    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    private int createRecipe(@RequestBody Recipe recipe){
        recipeService.saveOrUpdateRecipes(recipe);
        return recipe.getId();
    }
}