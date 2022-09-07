package tech.zyambo.srapi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileStorage {
    public void createFile(){
        try {
            File myDB = new File("db.txt");
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

    public void writeToFile(String recipe){
        try {
            FileWriter myWriter = new FileWriter("db.txt", true);
            BufferedWriter br = new BufferedWriter(myWriter);
            br.write(recipe + "\r\n");
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
            File myObj = new File("db.txt");
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
