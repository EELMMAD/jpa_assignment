package se.lexicon.elmira.jpa_assignment.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "recipeIngredient_id", updatable = false, nullable = false)
    private String recipeIngredientId;
    @ManyToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Ingredient ingredient;



    @ManyToOne(
            cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH},
            fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "recipe_id")
    private Recipe recipe;


    private double amount;
    private Measurement measurement;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement) {
        setAmount(amount);
        setIngredient(ingredient);
        setMeasurement(measurement);
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(recipeIngredientId, that.recipeIngredientId) &&
                Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(recipe, that.recipe) &&
                measurement == that.measurement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientId, ingredient, recipe, amount, measurement);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", ingredient=" + ingredient +
                ", recipe=" + recipe +
                ", amount=" + amount +
                ", measurement=" + measurement +
                '}';
    }
}


