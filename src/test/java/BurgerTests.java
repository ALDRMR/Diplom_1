import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BurgerTests {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;


    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);

        assertEquals(
                mockBun,
                burger.bun,
                "Переданный Bun не соответствует тому что в созданном Burger");
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);

        assertEquals(
                1,
                burger.ingredients.size(),
                "Размер списка ингредиентов должен быть равен 1");
        assertEquals(
                mockIngredient1,
                burger.ingredients.get(0),
                "Добавленный ингредиент должен совпадать с переданным");
    }

}
