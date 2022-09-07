package tech.zyambo.srapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Recipe {
    public String name;
    private final UUID id;
    public String mealTime;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    public String creator;
    public String country;
    public HashMap<String, Integer> prep;
    public ArrayList<String> ingredients;
    public ArrayList<String> description;
    public ArrayList<String> nutrition;
       

    // Recipe class constructor
    public Recipe(){
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.editedAt = LocalDateTime.now();
    }

    // Getter methods
    public UUID getId(){
        return id;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getEditedAt(){
        return editedAt;
    }

    /*Methods to add Recipe information */
    public void addPrepTime(HashMap<String, Integer> prep){
        this.prep = prep;
    }
    public void addData(String mealTime, String creator, String country){
        this.mealTime= mealTime;
        this.country = country;
        this.creator = creator;        
    }

    public void addIngredients(ArrayList<String> ingredients){
        this.ingredients = ingredients;

    }

    public void addDescription(ArrayList<String> description){
        this.description = description;
    }

    public void addNutrition(ArrayList<String> nutrition){
        this.nutrition = nutrition;
    }

}