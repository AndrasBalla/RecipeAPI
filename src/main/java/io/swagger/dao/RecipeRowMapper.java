package io.swagger.dao;

import io.swagger.model.Recipe;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Row mapper to map a recipe object.
 */
public class RecipeRowMapper implements RowMapper<Recipe> {
    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs != null) {
            Recipe recipe = new Recipe();
            recipe.setId(rs.getInt("id"));
            recipe.setName(rs.getString("name"));
            recipe.setCalories(rs.getString("calories"));

            return recipe;
        }else{
            return null;
        }
    }
}
