import com.shopping.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testCalculateItemCost() {
        ShoppingCart cart = new ShoppingCart(Locale.ENGLISH);
        assertEquals(20.0, cart.calculateItemCost(10.0, 2));
    }

    @Test
    void testAddItemAndTotalCost() {
        ShoppingCart cart = new ShoppingCart(Locale.ENGLISH);
        cart.addItem(5.0, 3); // 15.0
        cart.addItem(2.0, 4); // 8.0
        assertEquals(23.0, cart.calculateTotalCost());
    }

    @Test
    void testGetMessage() {
        ShoppingCart cart = new ShoppingCart(new Locale("en", "US"));
        assertEquals("Enter the number of items to purchase:", cart.getMessage("prompt.items"));
    }
}
