package tech.zyambo.srapi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            
            Gson gson = new Gson();
            String rData = gson.toJson(data);

            br.write(rData + "\r\n");
            br.close();
            myWriter.close();
            System.out.println("Successfully wrote to file.");
        } catch (Exception e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public void readFile(){
        try {
            File myObj = new File("db.json");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNext()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
            createFile();
        }
    }
}
