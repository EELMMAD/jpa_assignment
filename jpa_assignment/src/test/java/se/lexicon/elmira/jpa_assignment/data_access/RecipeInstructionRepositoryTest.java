package se.lexicon.elmira.jpa_assignment.data_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.elmira.jpa_assignment.entity.Ingredient;
import se.lexicon.elmira.jpa_assignment.entity.RecipeInstruction;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeInstructionRepositoryTest {
    RecipeInstruction testRecipeInstruction;


    @Autowired
    RecipeInstructionRepository recipeInstructionRepository;



    @BeforeEach
    void setUp() {
        testRecipeInstruction = recipeInstructionRepository.save(new RecipeInstruction("First Instruction"));
        recipeInstructionRepository.save(new RecipeInstruction("Second Instruction"));
        recipeInstructionRepository.save(new RecipeInstruction("Third Instruction"));
        recipeInstructionRepository.save(new RecipeInstruction("4Th Instruction"));
        recipeInstructionRepository.save(new RecipeInstruction("5th Instruction"));

    }

    @Test
    void successfullyCreated() {
        assertNotNull(testRecipeInstruction);
        assertTrue(testRecipeInstruction.getInstruction_id() != null);
        assertEquals("First Instruction", testRecipeInstruction.getInstructions());
    }

    @Test
    void findAll() {
        assertEquals(5, recipeInstructionRepository.findAll().size());
    }


    @AfterEach
    void tearDown() {
    }
}