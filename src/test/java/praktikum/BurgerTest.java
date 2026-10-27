
package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    private Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();

        lenient().when(bun.getName()).thenReturn("black bun");
        lenient().when(bun.getPrice()).thenReturn(100.0f);

        lenient().when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        lenient().when(sauce.getName()).thenReturn("hot sauce");
        lenient().when(sauce.getPrice()).thenReturn(50.0f);

        lenient().when(filling.getType()).thenReturn(IngredientType.FILLING);
        lenient().when(filling.getName()).thenReturn("cutlet");
        lenient().when(filling.getPrice()).thenReturn(200.0f);
    }

    @Test
    void setBunsSetsCorrectBun() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    void addIngredientAddsIngredient() {
        burger.addIngredient(sauce);

        assertEquals(1, burger.ingredients.size());
        assertSame(sauce, burger.ingredients.get(0));
    }

    @Test
    void removeIngredientRemovesIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertSame(filling, burger.ingredients.get(0));
    }

    @Test
    void moveIngredientMovesIngredientToNewPosition() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(0, 1);

        assertSame(filling, burger.ingredients.get(0));
        assertSame(sauce, burger.ingredients.get(1));
    }

    @Test
    void getPriceReturnsDoubleBunPriceAndIngredientsPrices() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        assertEquals(450.0f, burger.getPrice(), 0.001f);
    }

    @Test
    void getPriceReturnsDoubleBunPriceWithoutIngredients() {
        burger.setBuns(bun);

        assertEquals(200.0f, burger.getPrice(), 0.001f);
    }

    @Test
    void getReceiptReturnsCorrectReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String receipt = burger.getReceipt();
        System.out.println(receipt);

        assertTrue(receipt.contains("(==== black bun ====)"));
        assertTrue(receipt.contains("= sauce hot sauce ="));
        assertTrue(receipt.contains("= filling cutlet ="));
        assertTrue(receipt.contains("Price: 450,000000"));
    }
}
