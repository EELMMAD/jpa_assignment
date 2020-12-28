package se.lexicon.elmira.jpa_assignment.data_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.elmira.jpa_assignment.entity.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {

    Recipe testRecipe;
    List<RecipeIngredient> testRecipeIngredients;
    List<RecipeCategory> testRecipeCategories;
    RecipeIngredient testRecipeIngredient1;
    RecipeIngredient testRecipeIngredient2;


    @Autowired
    RecipeRepository recipeRepository;


    @BeforeEach
    void setUp() {
        testRecipe = new Recipe();
        testRecipe.setRecipe_name("Test recipe");
        testRecipe.setRecipeInstruction(new RecipeInstruction("Instruction of test recipe"));
        testRecipeIngredient1 = new RecipeIngredient(new Ingredient("Ingredient 1"),4, Measurement.KG);
        testRecipeIngredient2 = new RecipeIngredient(new Ingredient("Ingredient 2"),100,Measurement.G);

        testRecipe.addRecipeIngredient(testRecipeIngredient1);
        testRecipe.addRecipeIngredient(testRecipeIngredient2);
        recipeRepository.save(testRecipe);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void successfully_created(){
        assertNotNull(testRecipe);
        assertEquals("Test recipe",testRecipe.getRecipe_name());
        assertEquals("Instruction of test recipe",testRecipe.getRecipeInstruction().getInstructions());
        assertEquals(2,testRecipe.getRecipeIngredients().size());
    }

    @Test
    void findAll() {
        assertEquals(1,recipeRepository.findAll().size());
    }

    @Test
    void findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase() {
        assertEquals(1,
                recipeRepository.findAllByRecipeIngredients_Ingredient_IngredientNameIgnoreCase("IngRediEnt 2").size());
    }
}