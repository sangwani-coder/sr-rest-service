package tech.zyambo.srapi;

class RecipeNotFoundException extends RuntimeException {

    RecipeNotFoundException(Integer id) {
      super(String.format("Could not find recipe with id %s", id));
    }
  }