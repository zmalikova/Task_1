package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BunTest {

    @ParameterizedTest
    @CsvSource({
            "black bun, 100.0",
            "white bun, 200.0",
            "red bun, 300.0"
    })
    void bunConstructorAndGettersReturnCorrectValues(
            String name, float price) {

        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice());
    }

    @Test
    void bunStoresZeroPrice() {
        Bun bun = new Bun("test bun", 0.0f);

        assertEquals(0.0f, bun.getPrice());
    }
}