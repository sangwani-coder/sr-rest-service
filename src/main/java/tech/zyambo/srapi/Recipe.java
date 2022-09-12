package tech.zyambo.srapi;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private String creator;
    private String country;
    private String prep;
    private String cook;
    private String servings;

    // no-arg constructor
    Recipe() {};

    // arg constructor
    public Recipe(String name, String creator) {
        this.name = name;
        this.creator = creator;
        this.createdAt = LocalDateTime.now();
        this.editedAt = LocalDateTime.now();
    }
    
    // GETTERS
    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
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
    public String getCountry(){
        return country;
    }

    public String getPrep(){
        return prep;
    }

    public String getCook(){
        return cook;
    }
    public String getServings(){
        return servings;
    }
    
    // SETTERS
    public void setId(Integer id){
        this.id  = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setcreatedAt(){
        this.createdAt = LocalDateTime.now();
    }
    public void seteditedAt(LocalDateTime edited){
        this.editedAt = LocalDateTime.now();
    }
    public void setCreator(String creator){
        this.creator = creator;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public void setPrep(String prep){
        this.prep = prep;
    }
    public void setCook(String cook){
        this.cook = cook;
    }
    public void setServings(String servings){
        this.servings = servings;
    }
    
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