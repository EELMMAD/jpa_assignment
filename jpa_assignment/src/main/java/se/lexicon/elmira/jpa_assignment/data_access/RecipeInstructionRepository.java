package se.lexicon.elmira.jpa_assignment.data_access;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.elmira.jpa_assignment.entity.RecipeInstruction;

import java.util.List;
import java.util.UUID;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, UUID> {
    List<RecipeInstruction> findAll();


}
