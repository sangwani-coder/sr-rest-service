package tech.zyambo.srapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RecipeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RecipeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String recipeNotFoundHandler(RecipeNotFoundException ex) {
    return ex.getMessage();
  }
}