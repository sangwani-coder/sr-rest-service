package tech.zyambo.srapi;

import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.Objects;

// import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
// import javax.persistence.Table;

// import org.springframework.context.annotation.Primary;

@Entity
// @Primary
// @Table
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    
    public String mealTime;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime editedAt;
    
    public String creator;
    
    public String country;
    
    // public HashMap<String, Integer> prep;
    
    // public ArrayList<String> ingredients;
    
    // public ArrayList<String> description;
    
    // public ArrayList<String> nutrition;
    
    // GETTERS
    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
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

    // public HashMap<String, Integer> getPrep(){
    //     return prep;
    // }

    // public ArrayList<String> getIngredients(){
    //     return ingredients;
    // }
    // public ArrayList<String> getDescription(){
    //     return description;
    // }
    // public ArrayList<String> getNutrintion(){
    //     return nutrition;
    // }

    // SETTERS
    public void setId(Integer id){
        this.id  = id;
    }
    public void setName(String name){
        this.name = name;
    }
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

    // public void getPrep(HashMap<String, Integer> prep){
    //     this.prep = prep;
    // }
    // public void getIngredients(ArrayList<String> ingr){
    //     this.ingredients = ingr;
    // }
    // public void getDescription(ArrayList<String> desc){
    //     this.description = desc;
    // }
    // public void getNutrintion(ArrayList<String> nutr){
    //     this.nutrition = nutr;
    // }   

    @Override
    public boolean equals(Object o) {
  
      if (this == o)
        return true;
      if (!(o instanceof Recipe))
        return false;
      Recipe recipe = (Recipe) o;
      return Objects.equals(this.id, recipe.id) && Objects.equals(this.name, recipe.name)
          && Objects.equals(this.creator, recipe.creator);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name, this.creator);
    }
  
    @Override
    public String toString() {
      return "Recipe{" + "id=" + this.id + ", name='" + this.name + '\'' + ", creator='" + this.creator + '\'' + '}';
    }

}