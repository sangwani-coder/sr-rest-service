package tech.zyambo.srapi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;

public class FileStorage {
    private String msg;
    public String createFile(String path){
        try {
            File myDB = new File(String.format("%s" + ".json", path));
            if (myDB.createNewFile()) {
                msg = String.format("File %s.json created successfully", path);
            } else {
                msg = String.format("File %s already exists", path);
            }
        } catch (IOException e) {
            msg = "An error occured.";
            e.printStackTrace();
        }
        return this.msg;
    }

    public String writeToFile(String path, String name, HashMap<String, Object> recipe){
        try {
            createFile(path);
            FileWriter myWriter = new FileWriter(path, true);
            BufferedWriter br = new BufferedWriter(myWriter);

            HashMap<String, Object> data = new HashMap<>();

            data.put(String.format("%s", name), recipe);
            
            // Gson gson = new Gson();
            // String rData = gson.toJson(data);
            long count = countLines(path);

            HashMap<Object, Object> jData = new HashMap<>();
            
            // add id as key
            jData.put(++count, data);
            Gson gson = new Gson();
            String jsonData = gson.toJson(jData);

            br.write(jsonData + "\r\n");
            br.close();
            myWriter.close();
        } catch (Exception e) {
            name = "an error occured.";
            e.printStackTrace();
        }
        return name;
    }

    public String readFile(){
        long count = 0;
        String jData;

        HashMap<Object, Object> recipes = new HashMap<>();
        HashMap<String, Object> myData = new HashMap<>();
        Gson gson = new Gson();
                
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
            createFile("db");
        }
        jData = gson.toJson(myData);
        return jData;
    }

    public long countLines(String path){
        long count = 0;
        try {
            // make a connection to the file
            Path file = Paths.get(path);
    
            // read all lines of the file
            count = Files.lines(file).count();
            System.out.println("Total Lines: " + count);
        
        } catch (Exception e) {
            e.getStackTrace();
        
        }
        return count;
    }
    
}
