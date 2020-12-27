package se.lexicon.elmira.jpa_assignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.elmira.jpa_assignment.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
    List<RecipeCategory> findAll();
}
