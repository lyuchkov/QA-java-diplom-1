import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void setBunNameEqualityTest(){
        String bunName = "Brioche";
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn(bunName);

        burger.setBuns(bun);

        assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void addIngredientNameEqualityTest() {
        String ingredientName ="Beef";
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);

        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        assertEquals(ingredientName, burger.ingredients.get(0).getName());
    }
}
