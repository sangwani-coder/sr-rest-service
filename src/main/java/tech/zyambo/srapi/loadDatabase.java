package tech.zyambo.srapi;

import java.util.ArrayList;

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
      Recipe porkChop = new Recipe("Crispy pork chops", "Dinner", "Sepiso");
      // add ingredients
      ArrayList<String> item= new ArrayList<>();
      item.add("1 kg of pork");
      item.add("1 kg of onion");
      item.add("1 kg of tomatoes");
      porkChop.setIngredient(item);
      // add nutrition info
      ArrayList<String> nuts = new ArrayList<>();
      nuts.add("nuts number 1");
      nuts.add("nuts number 2");
      nuts.add("nuts number 3");
      nuts.add("nuts number 3");
      nuts.add("nuts number 3");
      nuts.add("nuts number 3");
      nuts.add("nuts number 3");
      porkChop.setNurition(nuts);
    
      // Dummy Recipe data 2
      Recipe peppers = new Recipe("Stuffed peppers", "Lunch","Sangwani");
      ArrayList<String> item1 = new ArrayList<>();
      item1.add("1 kg of pork");
      item1.add("1 kg of onion");
      item1.add("1 kg of tomatoes");
      peppers.setIngredient(item1);

      // Dummy Recipe data 3
      Recipe anotherRecipe = new Recipe("Potato Salad", "Breakfast","Zyambo");
      ArrayList<String> item2 = new ArrayList<>();
      item2.add("1 kg of pork");
      item2.add("1 kg of onion");
      item2.add("1 kg of tomatoes");
      anotherRecipe.setIngredient(item2);

      ArrayList<String> step = new ArrayList<>();
      step.add("Step number 1");
      step.add("Step number 2");
      step.add("Step number 3");
      step.add("Step number 3");
      step.add("Step number 3");
      step.add("Step number 3");
      step.add("Step number 3");
      anotherRecipe.setCookDirections(step);
      
      // save data to reposiory a and print data to console
      log.info("Preloading " + repository.save(porkChop));
      log.info("Preloading " + repository.save(peppers));
      log.info("Preloading " + repository.save(anotherRecipe));
    };
  }
}