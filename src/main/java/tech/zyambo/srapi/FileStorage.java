package tech.zyambo.srapi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;

public class FileStorage {
    public void createFile(){
        try {
            File myDB = new File("db.json");
            if (myDB.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public void writeToFile(String name, HashMap<String, Object> recipe){
        try {
            FileWriter myWriter = new FileWriter("db.json", true);
            BufferedWriter br = new BufferedWriter(myWriter);

            HashMap<String, Object> data = new HashMap<>();

            data.put(String.format("%s", name), recipe);
            
            // Gson gson = new Gson();
            // String rData = gson.toJson(data);
            long count = countLines();

            HashMap<Object, Object> jData = new HashMap<>();
            
            // add id as key
            jData.put(++count, data);
            Gson gson = new Gson();
            String jsonData = gson.toJson(jData);

            br.write(jsonData + "\r\n");
            br.close();
            myWriter.close();
            System.out.println("Successfully wrote to file.");
        } catch (Exception e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public HashMap<String, Object> readFile(){
        long count = 0;

        HashMap<Object, Object> recipes = new HashMap<>();
        HashMap<String, Object> myData = new HashMap<>();
        
        try {
            File myObj = new File("db.json");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNext()) {
                String data = myReader.nextLine();
                recipes.put(++count, data);
                // System.out.println(recipes);
            }
            myData.put("total recipes", count);
            myData.put("recipes", recipes);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
            createFile();
        }

        return myData;
    }

    public long countLines(){
        long count = 0;
        try {
            // make a connection to the file
            Path file = Paths.get("db.json");
    
            // read all lines of the file
            count = Files.lines(file).count();
            System.out.println("Total Lines: " + count);
        
        } catch (Exception e) {
            e.getStackTrace();
        
        }
        return count;
    }
    
}
