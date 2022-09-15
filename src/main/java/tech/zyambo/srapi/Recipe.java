package tech.zyambo.srapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;  

@Entity
@SecondaryTable(name = "recipe_details",
    pkJoinColumns = @PrimaryKeyJoinColumn(
        name = "recipeId", referencedColumnName = "id"))
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String recipeName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private String creator;
    private String country;
    private String prep;
    private String cook;
    private String servings;
    private String category;

    // Secondary RecipeIngredients table attributes
    @Column(table = "recipe_details", length = 300)
    // key; ingredient
    // value: quantity
    private ArrayList<String> ingredients;
    @Column(length = 400)
    private HashMap<Integer, String> cookDirections;
    @Column(length = 300)
    private ArrayList<String> nutrients;

    // no-arg constructor
    Recipe() {};

    // arg constructor
    public Recipe(String recipeName, String category, String creator) {
        this.recipeName = recipeName;
        this.category = category;
        this.creator = creator;
        this.createdAt = LocalDateTime.now();
        this.editedAt = LocalDateTime.now();
    }
    
    /** 
     * @return Integer
     */
    public Integer getId(){
        return id;
    }

    
    /** 
     * @return String
     */
    public String getRecipeName(){
        return recipeName;
    }

    
    /** 
     * @return String
     */
    public String getDescription(){
        return description;
    }
    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getcreatedAt(){
        return createdAt;
    }
    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime geteditedAt(){
        return editedAt;
    }
    
    /** 
     * @return String
     */
    public String getCreator(){
        return creator;
    }
    
    /** 
     * @return String
     */
    public String getCountry(){
        return country;
    }

    
    /** 
     * @return String
     */
    public String getPrep(){
        return prep;
    }

    
    /** 
     * @return String
     */
    public String getCook(){
        return cook;
    }
    
    /** 
     * @return String
     */
    public String getServings(){
        return servings;
    }
    
    /** 
     * @return String
     */
    public String getCategory(){
        return category;
    }

    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getIngredient(){
        return ingredients;
    }

    
    /** 
     * @return ArrayList<String>
     */
    public HashMap<Integer, String> getCookDirections(){
        return cookDirections;
    }

    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getnutrients(){
        return nutrients;
    }
    
    
    /** 
     * @param id
     */
    public void setId(Integer id){
        this.id  = id;
    }
    
    /** 
     * @param recipeName
     */
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }
    
    /** 
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }
    public void setcreatedAt(){
        this.createdAt = LocalDateTime.now();
    }
    
    /** 
     * @param edited
     */
    public void seteditedAt(){
        this.editedAt = LocalDateTime.now();
    }
    
    /** 
     * @param creator
     */
    public void setCreator(String creator){
        this.creator = creator;
    }
    
    /** 
     * @param country
     */
    public void setCountry(String country){
        this.country = country;
    }

    
    /** 
     * @param prep
     */
    public void setPrep(String prep){
        this.prep = prep;
    }
    
    /** 
     * @param cook
     */
    public void setCook(String cook){
        this.cook = cook;
    }
    
    /** 
     * @param servings
     */
    public void setServings(String servings){
        this.servings = servings;
    }
    
    /** 
     * @param category
     */
    public void setCategory(String category){
        this.category = category;
    }

    
    /** 
     * @param item
     */
    public void setIngredient(ArrayList<String> item){
        this.ingredients = item;
    }
    
     
     /** 
      * @param step
      */
     public void setCookDirections(HashMap<Integer, String> step){
        this.cookDirections = step;
    }
     
     
     /** 
      * @param nutrient
      */
     public void setNurition(ArrayList<String> nutrient){
        this.nutrients = nutrient;
    }
        
    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
  
      if (this == o)
        return true;
      if (!(o instanceof Recipe))
        return false;
      Recipe recipe = (Recipe) o;
      return Objects.equals(this.id, recipe.id) && Objects.equals(this.recipeName, recipe.recipeName)
          && Objects.equals(this.creator, recipe.creator);
    }
  
    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.recipeName, this.creator);
    }
  
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
      return "Recipe{" + "id=" + this.id + ", recipeName='" + this.recipeName + '\'' + ", creator='" + this.creator + '\'' + '}';
    }

}