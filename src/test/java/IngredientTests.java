import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class IngredientTests {

    static Stream<Arguments> ingredientDataProvider() {
        return Stream.of(
                of(IngredientType.SAUCE, "Кетчуп", 45.6f),
                of(IngredientType.FILLING, "Котлета", 234f)
        );
    }

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    void getTypeReturnsCorrectType(IngredientType expectedType, String name, float price) {
        Ingredient ingredient = new Ingredient(expectedType, name, price);
        assertEquals(expectedType, ingredient.getType(), "Неверный тип");
    }

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    void getNameReturnsCorrectName(IngredientType type, String expectedName, float price) {
        Ingredient ingredient = new Ingredient(type, expectedName, price);
        assertEquals(expectedName, ingredient.getName(), "Неверное имя");
    }

    @ParameterizedTest
    @MethodSource("ingredientDataProvider")
    void getPriceReturnsCorrectPrice(IngredientType type, String name, float expectedPrice) {
        Ingredient ingredient = new Ingredient(type, name, expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), "Неверная цена");
    }

}
