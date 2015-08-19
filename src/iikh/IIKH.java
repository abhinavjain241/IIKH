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
                    recipeDB.addRecipe();
                    break;
                }
                
                case 1: {
                    System.out.println("Editing Recipe");
                    
                    System.out.println("Enter the Recipe id to be edited");
                    int rid = in.nextInt();
                    recipeDB.editRecipe(rid);
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
