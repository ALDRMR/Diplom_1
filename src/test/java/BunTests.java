import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTests {

    private final String expectedName = "Ржаная булочка";
    private final float expectedPrice = 123.4f;

        @Test
        public void bunNameGetterTest() {
            Bun bun = new Bun(expectedName, expectedPrice);

            assertEquals(expectedName, bun.getName(), "Неверное имя");
        }

        @Test
        public void bunPriceGetterTest() {
            Bun bun = new Bun(expectedName, expectedPrice);

            assertEquals(expectedPrice, bun.getPrice(), 0f, "Неверная цена");
        }

}
