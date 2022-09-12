package tech.zyambo.srapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RecipeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Recipe("Crispy pork chops", "Sepiso")));
      log.info("Preloading " + repository.save(new Recipe("Stuffed peppers", "Sangwani")));
    };
  }
}