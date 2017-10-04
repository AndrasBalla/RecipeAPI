package io.swagger.api;

import io.swagger.model.Recipe;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-04T16:46:36.624Z")

@Api(value = "recipes", description = "the recipes API")
public interface RecipesApi {

    @ApiOperation(value = "adds an recipe item", notes = "Adds a recipe to the system", response = Void.class, tags={ "food", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "item created", response = Void.class),
        @ApiResponse(code = 400, message = "invalid input, object invalid", response = Void.class) })
    @RequestMapping(value = "/recipes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addRecipe(@ApiParam(value = "Recipe item to add"  ) @RequestBody Recipe recipe);


    @ApiOperation(value = "Get a list of foods", notes = "Call the API for a list of recipes", response = Recipe.class, responseContainer = "List", tags={ "food", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Recipe.class),
        @ApiResponse(code = 404, message = "Not Found", response = Recipe.class) })
    @RequestMapping(value = "/recipes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Recipe>> getFoods();

}
