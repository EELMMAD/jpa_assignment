package se.lexicon.elmira.jpa_assignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.elmira.jpa_assignment.entity.RecipeIngredient;

import java.util.List;
import java.util.UUID;

public interface RecipeIngredientRepository  extends CrudRepository <RecipeIngredient, UUID>{
    List<RecipeIngredient> findAll();
}
