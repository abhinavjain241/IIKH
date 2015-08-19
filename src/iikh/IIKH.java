/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class IIKH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome to IIKH \n");
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("Enter 0 for adding recipe");
            System.out.println("Enter 1 for editing recipe");
            System.out.println("Enter 2 for viewing recipe");
            System.out.println("Enter 3 for creating a plan");
            System.out.println("Enter 4 for viewing a plan");
            
            Database recipeDB = new Database();
            int action = in.nextInt();
            System.out.println("You entered - " + action);
            
            switch(action){
                case 0: {
                    System.out.println("Adding Recipe");
                    
                    System.out.println("Enter the name of Recipe:");
                    String cstr = in.nextLine();
                    String rname = in.nextLine();
                    System.out.println("Enter the ingredients of Recipe:");
                    String ingr = in.nextLine();
                    System.out.println("Enter the instructions of Recipe:");
                    String inst = in.nextLine();
                    
                    Recipe r = new Recipe(rname, ingr, inst);
                    recipeDB.addRecipe(r);
                    break;
                }
                
                case 1: {
                    System.out.println("Editing Recipe");
                    
                    System.out.println("Enter the Recipe id to be edited");
                    int rid = in.nextInt();
                    System.out.println("Enter 0 for editing name");
                    System.out.println("Enter 1 for editing ingredients");
                    System.out.println("Enter 2 for editing instructions");
                    int act = in.nextInt();
                    String redit=null;
                    if(act==0){
                        System.out.println("Enter new name");
                        redit = in.nextLine();
                    }
                    else if(act==1){
                        System.out.println("Enter the new ingredients");
                        redit = in.nextLine();
                    }
                    else{
                        System.out.println("Enter new instructions");
                        redit = in.nextLine();
                    }
                    recipeDB.editRecipe(rid, act, redit);
                    break;
                }
                
                case 2: {
                    System.out.println("Viewing recipe");
                    System.out.println("Enter the Recipe id to be viewed");
                    int rid = in.nextInt();
                    recipeDB.viewRecipe(rid);
                    break;
                }
                    
                case 3: System.out.println("Creating a plan");
                        break;
                
                case 4: System.out.println("Viewing a plan");
                        break;
                
                default: System.out.println("Select another option");
            }
        }
    }
    
}
