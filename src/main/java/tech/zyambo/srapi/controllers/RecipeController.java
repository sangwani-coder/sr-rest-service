package tech.zyambo.srapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.zyambo.srapi.FileStorage;
import tech.zyambo.srapi.Recipe;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping(path="/srapi/v1/recipes", produces="application/json")
public class RecipeController {

     @GetMapping("/")
     @ResponseStatus(HttpStatus.ACCEPTED)
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("data", "/srapi/v1/data");
        resUrls.put("vegan", "/srapi/v1/vegan");
        resUrls.put("vegetarian", "/srapi/v1/vegetarian");
        resUrls.put("recipes", "/srapi/v1/recipes");       

        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }

    public void createRecipe(
        @RequestBody Recipe data,
        @RequestParam String name,
        String group){        
        
        String Jmsg;
        HashMap<String, Object> recipeData = new HashMap<>();
        HashMap<String, String> msg = new HashMap<>();

        // Convert datetime and uuid objects to string
        String created =  data.getCreatedAt().toString();
        String edited =  data.getEditedAt().toString();
        String recipeID = data.getId().toString();
                
        try {
            recipeData.put("id", recipeID);
            recipeData.put("creator", data.creator);
            recipeData.put("group", group);
            recipeData.put("mealTime", data.mealTime);
            recipeData.put("description", data.description);
            recipeData.put("prep", data.prep);
            recipeData.put("ingredients", data.ingredients);
            recipeData.put("country", data.country);
            recipeData.put("nutrition", data.nutrition);
            recipeData.put("createdAt", created);
            recipeData.put("editedAt", edited);

            FileStorage fileWriter = new FileStorage();
            fileWriter.createFile();
            fileWriter.writeToFile(name, recipeData);

            // msg.put("message", "ok");
            // Gson gson = new Gson();
            // Jmsg = gson.toJson(msg);
           
        } catch(Exception e){
            e.printStackTrace();

        }
    }

}