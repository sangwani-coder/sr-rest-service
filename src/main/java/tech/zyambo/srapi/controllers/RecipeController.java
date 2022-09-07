package tech.zyambo.srapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.zyambo.srapi.FileStorage;
import tech.zyambo.srapi.Recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@RestController
@RequestMapping(path="/srapi/v1/recipes", produces="application/json")
public class RecipeController {

     @GetMapping("")
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

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> get(){
        FileStorage myObj = new FileStorage();
        HashMap<String, Object> d = new HashMap<>();
        d = myObj.readFile();
        
        return d;
   }

    public void createRecipe(
        @RequestBody Recipe data,
        @RequestParam String name,
        String group){        
        
        HashMap<String, Object> recipeData = new HashMap<>();

        try {
            // Convert datetime and uuid objects to string
            String created =  data.getcreatedAt().toString();
            String edited =  data.geteditedAt().toString();
            String recipeID = data.getId().toString();

            FileStorage fileWriter = new FileStorage();
            fileWriter.createFile();

            recipeData.put("id", recipeID);
            recipeData.put("creator", data.creator);
            recipeData.put("group", group);
            recipeData.put("mealTime", data.mealTime);
            recipeData.put("description", data.description);
            recipeData.put("prep", data.prep);
            recipeData.put("ingredients", data.ingredients);
            recipeData.put("country", data.country);
            recipeData.put("nutrition", data.nutrition);
            recipeData.put("created", created);
            recipeData.put("edited", edited);

            fileWriter.writeToFile(name, recipeData);
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}