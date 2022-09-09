//Tests the FileStorage class
package tech.zyambo.srapi;

// import org.junit.Rule;
// import org.junit.rules.TemporaryFolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

// import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileStorageTests {
    // Create a new temp folder
    private final FileStorage fileWriter = new FileStorage();

    @Test
    void testCreateNewFile(){
        // test whether the file has been created
        assertEquals("File test.json created successfully", this.fileWriter.createFile("test"));
    }

    @Test
    void testWriteToFile(){
        String path = "testDB.json";
        String recipe = "MyFavoriteRecipe";
        HashMap<String, Object> recipeData = new HashMap<>();

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

            String response = fileWriter.writeToFile(path, recipe, recipeData);
            assertEquals(recipe, response);
           
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
