package tech.zyambo.srapi.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.zyambo.srapi.Vegetarian;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class VegetarianController {
    
    @GetMapping("/vegetarian")
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("breakfast", "/srapi/v1/vegetarian/breakfast");
        resUrls.put("lunch", "/srapi/v1/vegetarian/lunch");
        resUrls.put("dinner", "/srapi/v1/vegetarian/dinner");
        
        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }
    
    @PostMapping("/vegetarian")
    public Vegetarian vegetarian(){
        Vegetarian myRecipe = new Vegetarian("Potato salad");

        return myRecipe;

    }
}