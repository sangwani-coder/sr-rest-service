package tech.zyambo.srapi;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  
  /** 
   * @param repository
   * @return CommandLineRunner
   */
  @Bean
  CommandLineRunner initDatabase(RecipeRepository repository) {

    return args -> {
      // Dummy Recipe data 1
      Recipe recipe1 = new Recipe("Stuffed Shells", "Dinner", "Sepiso");
      // add ingredients
      ArrayList<String> item= new ArrayList<>();
      item.add("2 tablespoons olive oil");
      item.add("garlic cloves, thinly sliced");
      item.add("1//2 teaspoon salt");
      recipe1.setIngredient(item);
       
      // Dummy Recipe data 2
      Recipe recipe2 = new Recipe("Tuscan Chicken Skillet", "Lunch","Sangwani");
            
      // Dummy Recipe data 3
      Recipe recipe3 = new Recipe("Easy butter chicken", "Breakfast","Zyambo");
      ArrayList<String> item2 = new ArrayList<>();
      item2.add("3-4 boneless skinless chicken thighs");
      item2.add("6 green cardamom pods");
      item2.add("pinch dried fenugree leaves");
      recipe3.setIngredient(item2);

      HashMap<Integer, String> step = new HashMap<>();
      step.put(1, "Preheat the oven to .....");
      step.put(2, "Heat the sunflower oil in a medium non-stick frying pan..");
      recipe3.setCookDirections(step);
      
      // save data to reposiory a and print data to console
      log.info("Preloading " + repository.save(recipe1));
      log.info("Preloading " + repository.save(recipe2));
      log.info("Preloading " + repository.save(recipe3));
    };
  }
}