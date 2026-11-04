import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTests {

        @Test
        public void bunGetterTest() {
            String expectedName = "Булочка";
            float expectedPrice = 123.4f;

            Bun bun = new Bun(expectedName, expectedPrice);

            assertAll(
                    () -> assertEquals(expectedName, bun.getName(), "Неверное имя"),
                    () -> assertEquals(expectedPrice, bun.getPrice(), 0f, "Неверная цена")
            );
        }

}
