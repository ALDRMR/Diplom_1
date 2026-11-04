import org.junit.jupiter.api.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTests {

    @Test
    public void ingredientGetterTest() {
        IngredientType expectedType = IngredientType.SAUCE;
        String expectedName = "Кетчуп";
        float expectedPrice = 45.6f;

        Ingredient ingredient = new Ingredient(
                expectedType,
                expectedName,
                expectedPrice);

        assertAll(
                () -> assertEquals(expectedType, ingredient.getType(), "Неверный тип"),
                () -> assertEquals(expectedName, ingredient.getName(), "Неверное имя"),
                () -> assertEquals(expectedPrice, ingredient.getPrice(), 0f, "Неверная цена")
        );
    }

}
