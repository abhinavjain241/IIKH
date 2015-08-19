/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abhinav Jain, 13MA20004
 */
public class Database {
    private List<Recipe> Recipes = new ArrayList<Recipe>();
    private List<Meal> Meals = new ArrayList<Meal>();
    Recipe toBeAdded;
    
    public void EditRecipe(int RecipeID){
        int choice;
        String newName, newIngr, newInstr;
        System.out.println("Which of the following do you want to change?");
        System.out.println("1. Name");
        System.out.println("2. Ingredients");
        System.out.println("3. Instructions");
        choice = Read.in.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter new name of the recipe:");
                newName = Read.in.nextLine();
                Recipes.get(RecipeID).setName(newName);
                break;
            case 2:
                System.out.println("Enter new Ingredients:");
                newIngr = Read.in.nextLine();
                Recipes.get(RecipeID).setIngredients(newIngr);
                break;
            case 3:
                System.out.println("Enter new Instructions:");
                newInstr = Read.in.nextLine();
                Recipes.get(RecipeID).setIngredients(newInstr);
                break;
            default:
                System.out.println("Didn't get choice (1/2/3), editing whole recipe..");
                System.out.println("Enter new name of the recipe:");
                newName = Read.in.nextLine();
                Recipes.get(RecipeID).setName(newName);
                System.out.println("Enter new Ingredients:");
                newIngr = Read.in.nextLine();
                Recipes.get(RecipeID).setIngredients(newIngr);
                System.out.println("Enter new Instructions:");
                newInstr = Read.in.nextLine();
                Recipes.get(RecipeID).setIngredients(newInstr);
                break;
        }
    }
    
    public void AddRecipe(){
        String Name, Ingr, Instr;
        System.out.println("Enter name of the recipe:");
        Name = Read.in.nextLine();
        toBeAdded.setName(Name);
        System.out.println("Enter Ingredients:");
        Ingr = Read.in.nextLine();
        toBeAdded.setIngredients(Ingr);
        System.out.println("Enter Instructions:");
        Instr = Read.in.nextLine();
        toBeAdded.setInstructions(Instr);
        Recipes.add(toBeAdded);
        System.out.println("ID of new recipe is: " + Recipe.getRecipeID());
    }
}
