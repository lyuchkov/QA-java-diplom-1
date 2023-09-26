import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private final Bun bun;
    private final List<Ingredient> ingredients;


    public BurgerParameterizedTest(Bun bun, List<Ingredient> ingredients) {
        this.bun = bun;
        this.ingredients = ingredients;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Ingredient> list1 = List.of(new Ingredient(IngredientType.SAUCE, "BBQ sauce", 10.0f), new Ingredient(IngredientType.FILLING, "Beef", 250.0f));
        List<Ingredient> list2 = List.of(new Ingredient(IngredientType.SAUCE, "Cheese sauce", 11.0f), new Ingredient(IngredientType.FILLING, "Pork", 200.0f));
        List<Ingredient> list3 = List.of(new Ingredient(IngredientType.SAUCE, "Cheese sauce", 11.0f), new Ingredient(IngredientType.FILLING, "Chicken", 250.0f));
        return Arrays.asList(
                new Object[]{new Bun("Fluorescent bun", 30.0f), list1},
                new Object[]{new Bun("Crater bun", 20.0f), list2},
                new Object[]{new Bun("Fluorescent bun", 30.0f), list3}
        );
    }

    @Test
    public void setBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredients.get(0));

        assertEquals(burger.ingredients.get(0), ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredients.get(0));

        assertEquals(burger.ingredients.get(0), ingredients.get(0));

        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient i : ingredients) {
            burger.addIngredient(i);
        }
        Ingredient ingredientWithIndex0 = burger.ingredients.get(0);
        Ingredient ingredientWithLastIndex = burger.ingredients.get(burger.ingredients.size() - 1);
        burger.moveIngredient(0, burger.ingredients.size() - 1);
        assertEquals(ingredientWithLastIndex.name, burger.ingredients.get(0).name);
        assertEquals(ingredientWithIndex0.name, burger.ingredients.get(burger.ingredients.size() - 1).name);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        float price = bun.price * 2;
        for (Ingredient i : ingredients) {
            burger.addIngredient(i);
            price += i.price;
        }

        assertEquals(price, burger.getPrice(), 0.0001);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient i : ingredients) {
            burger.addIngredient(i);
        }
        String r = getCorrectReceipt(burger);
        assertEquals(r, burger.getReceipt());
    }

    private String getCorrectReceipt(Burger burger) {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        return receipt.toString();
    }
}
