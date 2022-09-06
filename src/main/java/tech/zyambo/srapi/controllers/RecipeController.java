package tech.zyambo.srapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping(path="/srapi/v1/api", produces="application/json")
public class RecipeController {

     @GetMapping("/")
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("omnivore", "/srapi/v1/api/omnivore");
        resUrls.put("vegan", "/srapi/v1/api/vegan");
        resUrls.put("vegetarian", "/srapi/v1/api/vegetarian");

        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }

    @GetMapping("/data")
    public ArrayList<Recipe> getData(){
        
        ArrayList<Recipe> arr = new ArrayList<>();

        Recipe recipeOne = new Recipe();
        Recipe recipeTwo = new Recipe();

        arr.add(recipeOne);
        arr.add(recipeTwo);

        return arr;
    }

}