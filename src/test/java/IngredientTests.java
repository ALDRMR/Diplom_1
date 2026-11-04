import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTests {

    @ParameterizedTest
    @CsvSource({
            "SAUCE, Кетчуп, 45.6f",
            "FILLING, Котлета, 234f"
    })
    public void ingredientGetterTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        Ingredient ingredient = new Ingredient(
                expectedType,
                expectedName,
                expectedPrice);

        assertAll(
                () -> assertEquals(expectedType, ingredient.getType(), "Неверный тип"),
                () -> assertEquals(expectedName, ingredient.getName(), "Неверное имя"),
                () -> assertEquals(expectedPrice, ingredient.getPrice(), "Неверная цена")
        );
    }

}
