/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class Database {
    private static int rcount=0;
    private static int mcount=0;
    private static ArrayList<Recipe> r = new ArrayList<>();
    private static Meal[] m;
    
    public Database(){
    }

    public static void editRecipe(int rid){
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 0 for editing name");
        System.out.println("Enter 1 for editing ingredients");
        System.out.println("Enter 2 for editing instructions");
        int act = in.nextInt();
        String redit=null;
        if(act==0){
            System.out.println("Enter new name");
            String gr = in.nextLine();
            redit = in.nextLine();
            r.get(rid).setName(redit);
        }
        else if(act==1){
            System.out.println("Enter the new ingredients");
            String gr = in.nextLine();
            redit = in.nextLine();
            r.get(rid).setIngredients(redit);
        }
        else if(act==2){
            System.out.println("Enter new instructions");
            String gr = in.nextLine();
            redit = in.nextLine();
            r.get(rid).setInstruction(redit);
        }
        else{
            System.out.println("Enter a valid input");
        }
    }
    
    public static void addRecipe(){
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of Recipe:");
        String rname = in.nextLine();
        System.out.println("Enter the ingredients of Recipe:");
        String ingr = in.nextLine();
        System.out.println("Enter the instructions of Recipe:");
        String inst = in.nextLine();

        r.add(new Recipe(rname, ingr, inst));
        rcount++;
    }
    
    public static void delRecipe(int rid){
        r.remove(rid);
    }
    public static void viewRecipe(int rid){
        if(rid>r.size())System.out.println("RecipeID doesnt exist");
        else System.out.println(r.get(rid).print());
    }
}
