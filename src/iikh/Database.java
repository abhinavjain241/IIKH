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
public class Database {
    private static int rcount=0;
    private static int mcount=0;
    private static Recipe[] r;
    private static Meal[] m;
    
    public Database(){
        
    }

    public void editRecipe(int rid, int act, String redit){
        if(act==0)r[rid].setName(redit);
        else if(act==1)r[rid].setIngredients(redit);
        else if(act==2)r[rid].setInstruction(redit);
    }
    
    public void addRecipe(Recipe rnew){
        r[rcount] = new Recipe(rnew);
        rcount++;
    }
    
    public String viewRecipe(int rid){
        return r[rid].print();
    }
}
