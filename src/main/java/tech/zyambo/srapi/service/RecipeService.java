package tech.zyambo.srapi.service;

import java.util.List;
import java.util.ArrayList;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import tech.zyambo.srapi.model.Recipe;
import tech.zyambo.srapi.repository.RecipeRepository;


@Service 
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;
    
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();  
        recipeRepository.findAll().forEach(recipe -> recipes.add(recipe));  
        return recipes;  
    }

    public Recipe getRecipeById(int id) {
        return recipeRepository.findById(id).get();  
    }

    public void delete(int id) {
        recipeRepository.deleteById(id);
    }

    public void saveOrUpdateRecipes(Recipe recipe) {
        recipeRepository.save(recipe); 
    }

}
