package tech.zyambo.srapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.zyambo.srapi.Recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class RecipeController {

     @GetMapping("/")
     @ResponseStatus(HttpStatus.ACCEPTED)
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("omnivore", "/srapi/v1/omnivore");
        resUrls.put("vegan", "/srapi/v1/vegan");
        resUrls.put("vegetarian", "/srapi/v1/vegetarian");
        resUrls.put("recipes", "/srapi/v1/recipes");
        

        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }

    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ArrayList<Recipe> getData(){
        
        ArrayList<Recipe> arr = new ArrayList<>();

        Recipe recipeOne = new Recipe();
        Recipe recipeTwo = new Recipe();

        arr.add(recipeOne);
        arr.add(recipeTwo);

        return arr;
    }

}