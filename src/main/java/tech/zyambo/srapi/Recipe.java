package tech.zyambo.srapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Recipe {
    public String name;
    private final UUID id;
    public String mealTime;
    public LocalDate createdAt;
    public LocalDate editedAt;
    public String creator;
    public String country;
    public HashMap<String, Integer> prep;
    public ArrayList<String> ingredients;
    public ArrayList<String> description;
    public ArrayList<String> nutrition;
       

    // Recipe class constructor
    public Recipe(){
        this.id = UUID.randomUUID();
        this.createdAt = LocalDate.now();
        this.editedAt = LocalDate.now();
    }

    // Getter methods
    public UUID getId(){
        return id;
    }

    public LocalDate getcreatedAt(){
        return createdAt;
    }

    public LocalDate geteditedAt(){
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