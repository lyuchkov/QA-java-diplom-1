import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private static final String BEEF_METEORITE = "Beef meteorite";
    private static final float DEFAULT_PRICE = 100.0f;

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, BEEF_METEORITE, DEFAULT_PRICE);

        IngredientType type = ingredient.getType();

        assertEquals(IngredientType.FILLING, type);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, BEEF_METEORITE, DEFAULT_PRICE);

        String name = ingredient.getName();

        assertEquals(BEEF_METEORITE,name);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,BEEF_METEORITE, DEFAULT_PRICE);

        float price = ingredient.getPrice();

        assertEquals(DEFAULT_PRICE,price, 0.0001);
    }


}
