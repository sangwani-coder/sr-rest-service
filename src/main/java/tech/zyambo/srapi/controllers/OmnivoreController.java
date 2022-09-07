package tech.zyambo.srapi.controllers;

// import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import tech.zyambo.srapi.FileStorage;
import tech.zyambo.srapi.Omnivore;
import tech.zyambo.srapi.Recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class OmnivoreController {
    
    @GetMapping("/omnivore")
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("breakfast", "/srapi/v1/omnivore/breakfast");
        resUrls.put("lunch", "/srapi/v1/omnivore/lunch");
        resUrls.put("dinner", "/srapi/v1/omnivore/dinner");
        
        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }

    @PostMapping("/omnivore")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOmnRecipe(@RequestBody Recipe omnivore){
        Omnivore myRecipe = new Omnivore("Potato salad");
        
        String Jmsg;

        HashMap<String, Object> recipeData = new HashMap<>();
        HashMap<String, String> msg = new HashMap<>();
        
        try {
            recipeData.put("creator", omnivore.creator);
            recipeData.put("group", "omnivore");
            recipeData.put("mealTime", omnivore.mealTime);
            recipeData.put("description", omnivore.description);
            recipeData.put("prep", omnivore.prep);
            recipeData.put("ingredients", omnivore.ingredients);
            recipeData.put("country", omnivore.country);
            recipeData.put("nutrition", omnivore.nutrition);

            FileStorage fileWriter = new FileStorage();
            fileWriter.createFile();
            fileWriter.writeToFile(myRecipe.getRecipeName(), recipeData);

            msg.put("message", "ok");
            Gson gson = new Gson();
            Jmsg = gson.toJson(msg);
           
        } catch(Exception e){
            msg.put("message", "failed");
            Gson gson = new Gson();
            Jmsg = gson.toJson(msg);

        }
        return (Jmsg);
    }

}