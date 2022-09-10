package tech.zyambo.srapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.zyambo.srapi.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer>  
{  
}  
