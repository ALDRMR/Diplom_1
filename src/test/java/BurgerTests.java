import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BurgerTests {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;


    @Test
    public void burgerSetBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);

        assertEquals(
                mockBun,
                burger.bun,
                "Переданный Bun не соответствует тому что в созданном Burger");
    }

    @Test
    public void burgerAddIngredientTest() {
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

    @Test
    public void burgerRemoveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);

        assertTrue(
                burger.ingredients.isEmpty(),
                "Список ингредиентов должен быть пустым после удаления");
    }

    @Test
    public void burgerMoveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        assertEquals(
                mockIngredient2,
                burger.ingredients.get(0),
                "Первый ингредиент должен стать mockIngredient2");
        assertEquals(
                mockIngredient1,
                burger.ingredients.get(1),
                "Второй ингредиент должен стать mockIngredient1");
    }

    @Test
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        Mockito.when(mockBun.getPrice()).thenReturn(123.4f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(45.6f);

        float expectedPrice = 292.4f;

        assertEquals(
                expectedPrice,
                burger.getPrice(),
                "через метод Burger рассчитана неверная цена");
    }

    @Test
    public void burgerGetReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        Mockito.when(mockBun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(mockBun.getPrice()).thenReturn(123.4f);

        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient1.getName()).thenReturn("Кетчуп");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(45.6f);

        Mockito.when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredient2.getName()).thenReturn("Котлета");
        Mockito.when(mockIngredient2.getPrice()).thenReturn(234f);

        String receipt = burger.getReceipt();
        System.out.println(receipt);

        assertAll("Проверка чека",
                () -> assertTrue(receipt.contains("(==== Ржаная булочка ====)")),
                () -> assertTrue(receipt.contains("= sauce Кетчуп =")),
                () -> assertTrue(receipt.contains("= filling Котлета =")),
                () -> assertTrue(receipt.contains("Price: 526.4"))
        );
    }

}
