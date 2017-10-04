package io.swagger.api;

import io.swagger.dao.RecipeRepository;
import io.swagger.model.Recipe;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-04T16:46:36.624Z")

@Controller
public class RecipesApiController implements RecipesApi {
    @Autowired
    RecipeRepository recipeRepository;
    List<Recipe> recipes;

    public ResponseEntity<Void> addRecipe(@ApiParam(value = "Recipe item to add"  ) @RequestBody Recipe recipe) {
        recipeRepository.insertRecipe(recipe);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Recipe>> getFoods() {
        recipes = recipeRepository.findAll();
        return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
    }

}
