/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhinav Jain, 13MA20004
 */
public class Recipe {
    private static int RecipeID = 0;
    private String Name, Ingredients, Instructions;
    
    Recipe(){
        RecipeID++;
    }
    
    public static int getRecipeID() {
        return RecipeID;
    }

    public String getName() {
        return Name;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public String getInstructions() {
        return Instructions;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
    }

    public void setInstructions(String Instructions) {
        this.Instructions = Instructions;
    }
    public void print(){
        /*
        Add variables here to be printed.
        */
        System.out.println(Name);
        System.out.println(Ingredients);
        System.out.println(Instructions);
    }
}
