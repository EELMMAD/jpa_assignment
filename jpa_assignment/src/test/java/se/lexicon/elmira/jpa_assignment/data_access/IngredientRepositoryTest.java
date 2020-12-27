package se.lexicon.elmira.jpa_assignment.data_access;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.elmira.jpa_assignment.entity.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientRepositoryTest {
    Ingredient testIngredient;


    @Autowired
    IngredientRepository ingredientRepository;


    @BeforeEach
    void setUp() {
        testIngredient = ingredientRepository.save(new Ingredient("Ingredient 1"));
        ingredientRepository.save(new Ingredient("Ingredient 2"));
        ingredientRepository.save(new Ingredient("Ingredient 3"));
        ingredientRepository.save(new Ingredient("Ingredient 4"));
        ingredientRepository.save(new Ingredient("Ingredient 5"));
    }

    @Test
    void successfullyCreated (){
        assertNotNull(testIngredient);
        assertTrue(testIngredient.getIngredient_id() != 0);
        assertEquals("Ingredient 1", testIngredient.getIngredient_name());
    }

    @Test
    void findAll(){
        assertEquals(5,ingredientRepository.findAll().size());
    }


    @AfterEach
    void tearDown() {
    }
}