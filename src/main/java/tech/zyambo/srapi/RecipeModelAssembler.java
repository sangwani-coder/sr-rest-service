/*
 * PACKAGE that defines the Spring HATEOAS RepresentationalModelAssembler
 * interface that converts the Recipe objects to Entity<Recipe> objects.
 */

package tech.zyambo.srapi;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class RecipeModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>> {

  @Override
  public EntityModel<Recipe> toModel(Recipe recipe) {

    return EntityModel.of(recipe, //
        linkTo(methodOn(RecipeController.class).one(recipe.getId())).withSelfRel(),
        linkTo(methodOn(RecipeController.class).all()).withRel("recipes"));
  }
}
