package tech.zyambo.srapi;

public class Omnivore extends Recipe{
    private String recipeName;
    private final String recipeGroup;

    public Omnivore(String name){
        this.recipeName = name;
        this.recipeGroup = "Omnivore";
    }

    public String getRecipeName(){
        return recipeName;
    }

    public void setRecipeName(String name){
        this.recipeName = name;
    }

    public String getRecipeGroup(){
        return recipeGroup;
    }
    
}
