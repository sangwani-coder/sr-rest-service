package tech.zyambo.srapi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column
    public String mealTime;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime editedAt;
    @Column
    public String creator;
    @Column
    public String country;
    @Column
    public HashMap<String, Integer> prep;
    @Column
    public ArrayList<String> ingredients;
    @Column
    public ArrayList<String> description;
    @Column
    public ArrayList<String> nutrition;
    
    // GETTERS
    public int getId(){
        return id;
    }
    public String getMealTime(){
        return mealTime;
    }
    public LocalDateTime getcreatedAt(){
        return createdAt;
    }
    public LocalDateTime geteditedAt(){
        return editedAt;
    }
    public String getCreator(){
        return creator;
    }
    public String getCounty(){
        return country;
    }

    public HashMap<String, Integer> getPrep(){
        return prep;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }
    public ArrayList<String> getDescription(){
        return description;
    }
    public ArrayList<String> getNutrintion(){
        return nutrition;
    }

    // SETTERS
    // public void setId(int id){
    //     this.id  = id;
    // }
    public void setMealTime(String mealTime){
        this.mealTime = mealTime;
    }
    public void setcreatedAt(){
        this.createdAt = LocalDateTime.now();
    }
    public void seteditedAt(LocalDateTime edited){
        this.editedAt = edited;
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
    public void setCounty(String country){
        this.country = country;
    }

    public void getPrep(HashMap<String, Integer> prep){
        this.prep = prep;
    }
    public void getIngredients(ArrayList<String> ingr){
        this.ingredients = ingr;
    }
    public void getDescription(ArrayList<String> desc){
        this.description = desc;
    }
    public void getNutrintion(ArrayList<String> nutr){
        this.nutrition = nutr;
    }   

}