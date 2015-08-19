/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

/**
 *
 * @author user
 */
public class Recipe {
    private static int rcount=0;
    private int rid;
    private String name;
    private String ingredients;
    private String instruction;
    
    public Recipe(String rname, String ingr, String inst){
        rid = rcount;
        name = rname;
        ingredients = ingr;
        instruction = inst;
        rcount++;
    }
    
    public Recipe(Recipe r){
        rid = r.rid;
        name = r.name;
        ingredients = r.ingredients;
        instruction = r.instruction;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    public String print(){
        String info = "Hello, add the recipe information here -nav";
        return info;
    }
}
