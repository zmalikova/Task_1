
package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @ParameterizedTest
    @CsvSource({
            "SAUCE, hot sauce, 100.0",
            "SAUCE, sour cream, 200.0",
            "FILLING, cutlet, 100.0"
    })
    void ingredientConstructorAndGettersReturnCorrectValues(
            IngredientType type, String name, float price) {

        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice());
    }
}
