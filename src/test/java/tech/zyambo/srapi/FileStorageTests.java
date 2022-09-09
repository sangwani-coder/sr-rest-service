//Tests the FileStorage class
package tech.zyambo.srapi;

// import org.junit.Rule;
// import org.junit.rules.TemporaryFolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

// import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class FileStorageTests {

    // Create a new temp folder
    private final FileStorage fileWriter = new FileStorage();
    private String path = "testDB";
    private String recipe = "MyFavoriteRecipe";
    HashMap<String, Object> recipeData = new HashMap<>();

    @BeforeAll
    public void setUp() throws IOException{
        this.fileWriter.createFile(path);
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
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testCreateNewFile(){
        // test whether the file has been created
        assertEquals("File test.json already exists", this.fileWriter.createFile("test"));
    }

    @Test
    void testWriteToFile(){
        String response = fileWriter.writeToFile(this.path, this.recipe, this.recipeData);
            assertEquals(this.recipe, response);        
    }

    @AfterAll
    public void tearDown() throws Exception {
        try {
            // make a connection to the file
            Path file = Paths.get(path);
            Files.delete(file);
        
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
