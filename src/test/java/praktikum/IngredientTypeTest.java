
package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @Test
    void ingredientTypeContainsSauceAndFilling() {
        assertArrayEquals(
                new IngredientType[]{IngredientType.SAUCE, IngredientType.FILLING},
                IngredientType.values()
        );
    }

    @Test
    void sauceHasCorrectName() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    void fillingHasCorrectName() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
