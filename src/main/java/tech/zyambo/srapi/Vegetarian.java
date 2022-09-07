package tech.zyambo.srapi;

public class Vegetarian extends Recipe{
    private String recipeName;
    private final String recipeGroup;

    public Vegetarian(String name){
        this.recipeName = name;
        this.recipeGroup = "Vegetrian";
    }

    public String getRecipeName(){
        return recipeName;
    }

    public String getRecipeGroup(){
        return recipeGroup;
    }
    
}
