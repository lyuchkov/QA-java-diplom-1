import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static final String BURGER_BUN_NAME =  "Burger Bun";
    private static final float DEFAULT_PRICE = 100.0f;
    @Test
    public void shouldSetAndGetName() {
        Bun bun = new Bun(BURGER_BUN_NAME, DEFAULT_PRICE);

        assertEquals(BURGER_BUN_NAME, bun.getName());
    }

    @Test
    public void shouldSetAndGetPrice() {
        Bun bun = new Bun(BURGER_BUN_NAME, DEFAULT_PRICE);

        assertEquals(DEFAULT_PRICE, bun.getPrice(), 0.0001);
    }


}
