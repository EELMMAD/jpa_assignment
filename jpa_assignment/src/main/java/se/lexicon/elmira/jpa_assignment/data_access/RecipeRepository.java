package se.lexicon.elmira.jpa_assignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.elmira.jpa_assignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAll();
    List<Recipe> findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase(String name);
}
