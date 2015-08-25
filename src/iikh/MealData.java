/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author abhinav
 */

public class MealData{
    String mealName;
    ArrayList<String> meals;
    
    private String parsetoString(String mealName, ArrayList<String> recipes){
        String out = mealName + ",,";
        for(String x: recipes)
            out += (x + "::");
      //  System.out.print( out + "vsd");
        return out;
    }
    public void addMeal(String mealName, ArrayList<String> recipes){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mealList.txt", true)))) {
            out.println(parsetoString(mealName, recipes));  
       //     System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
     //   System.out.print("ksadlvbw");
    }  
    public ArrayList<String> mealNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("mealList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getMeal(String mealName){
        BufferedReader br = null;
        this.mealName = null;
        this.meals = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("mealList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(mealName)){
                    this.mealName = mealName;
                    this.meals = new ArrayList<String>(Arrays.asList(x[1].split("::")));
                }
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editMeal(String oldmealName, String newmealName, ArrayList<String> recipes){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("mealList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (tokens[0].equals(oldmealName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newmealName, recipes);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("mealList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeMeal(String mealName ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("mealList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (!tokens[0].equals(mealName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("mealList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getRecipes(){
        return this.meals;
    }
}
