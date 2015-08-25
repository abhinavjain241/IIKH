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
 * @author oop31
 */

public class Database {
    String recipeName;
    ArrayList<String> indegrients;
    ArrayList<String> method;
    
    private String parsetoString(String recipeName, ArrayList<String> indegrients, ArrayList<String> method){
        String out = recipeName + ",,";
        for(String x: indegrients)
            out += (x + "::");
        out += ",,";
        for(String x: method)
            out += (x + "::");
        System.out.print( out );
        return out;
    }
    public void addRecipe(String recipeName, ArrayList<String> indegrients, ArrayList<String> method){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recipeList.txt", true)))) {
            out.println(parsetoString(recipeName, indegrients, method));  
       //     System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
     //   System.out.print("ksadlvbw");
    }  
    public ArrayList<String> repNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
     //   System.out.println("here ");
	try {
            String line;
            br = new BufferedReader(new FileReader("recipeList.txt"));
          //  System.out.println("here ");
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
      //  System.out.println("here ");
        return list;       
    }    
    public void getRecipe(String recipeName){
        BufferedReader br = null;
        this.recipeName = null;
        this.indegrients = null;
        this.method = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("recipeList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(recipeName)){
                    this.recipeName = recipeName;
                    this.indegrients = new ArrayList<String>(Arrays.asList(x[1].split("::")));
                    this.method = new ArrayList<String>(Arrays.asList(x[2].split("::")));
                }
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editRecipe(String oldRecipeName, String newRecipeName, ArrayList<String> indegrients, ArrayList<String> method ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("recipeList.txt");
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
                    if (tokens[0].equals(oldRecipeName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newRecipeName, indegrients, method);
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
            FileWriter fstreamWrite = new FileWriter("recipeList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeRecipe(String RecipeName ){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("recipeList.txt");
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
                    if (!tokens[0].equals(RecipeName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("recipeList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<String> getIndegrients(){
        return this.indegrients;
    }
    public ArrayList<String> getMethod(){
        return this.method;
    }
}
