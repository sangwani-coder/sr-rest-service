package tech.zyambo.srapi;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}