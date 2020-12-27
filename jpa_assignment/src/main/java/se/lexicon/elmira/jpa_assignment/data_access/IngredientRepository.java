package se.lexicon.elmira.jpa_assignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.elmira.jpa_assignment.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    List<Ingredient> findAll();
    
}
