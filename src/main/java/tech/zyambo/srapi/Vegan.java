package tech.zyambo.srapi;

public class Vegan extends Recipe{
    private String recipeName;
    private final String recipeGroup;

    public Vegan(String name){
        // this.recipeName = name;
        this.recipeGroup = "Vegan";
    }

    // public String getRecipeName(){
    //     return recipeName;
    // }

    public String getRecipeGroup(){
        return recipeGroup;
    }
    
}
