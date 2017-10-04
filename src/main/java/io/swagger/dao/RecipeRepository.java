package io.swagger.dao;

import io.swagger.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RecipeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Find and return all recipes that are in the database.
     * @return List of Recipe objects
     */
    @Transactional(readOnly=true)
    public List<Recipe> findAll() {
        return jdbcTemplate.query("select * from recipes", new RecipeRowMapper());
    }


    @Transactional(readOnly=false)
    public void insertRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (name, calories) VALUES (?, ?)";
        jdbcTemplate.update(sql, recipe.getName(), recipe.getCalories());
    }
}
