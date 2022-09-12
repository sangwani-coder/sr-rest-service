package tech.zyambo.srapi;

class RecipeNotFoundException extends RuntimeException {

    RecipeNotFoundException(Integer id) {
      super("Could not find recipe " + id);
    }
  }