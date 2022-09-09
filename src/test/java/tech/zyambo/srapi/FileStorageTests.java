//Tests the FileStorage class
package tech.zyambo.srapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

// import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileStorageTests {
    // Create variables
    private final FileStorage fileWriter = new FileStorage();
    private String path = "testDB.json";
    private String recipe = "MyFavoriteRecipe";
    private HashMap<String, Object> recipeData = new HashMap<>();

    @Test
    void testCreateNewFileNoneExisting(){
        // test whether the file has been created
        Path file = Paths.get(this.path);
        boolean exists = Files.exists(file);
        assumeFalse(exists);

        assertEquals("File test.json created successfully", this.fileWriter.createFile(this.path));
    }

    @Test
    void testCreateNewFileExisting(){
        // test whether the file has been created
        Path file = Paths.get(this.path);
        boolean exists = Files.exists(file);
        assumeTrue(exists);
        
        assertEquals("File test.json already exists", this.fileWriter.createFile(this.path));
    }

    @Test
    void testWriteToFile(){
        
        Recipe data = new Recipe();

        try {
            // Convert datetime and uuid objects to string
            String created =  data.getcreatedAt().toString();
            String edited =  data.geteditedAt().toString();
            String recipeID = data.getId().toString();

            recipeData.put("id", recipeID);
            recipeData.put("creator", data.creator);
            recipeData.put("group", "vegan");
            recipeData.put("mealTime", data.mealTime);
            recipeData.put("description", data.description);
            recipeData.put("prep", data.prep);
            recipeData.put("ingredients", data.ingredients);
            recipeData.put("country", data.country);
            recipeData.put("nutrition", data.nutrition);
            recipeData.put("created", created);
            recipeData.put("edited", edited);

            String response = fileWriter.writeToFile(this.path, this.recipe, this.recipeData);
            assertEquals(this.recipe, response);
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
