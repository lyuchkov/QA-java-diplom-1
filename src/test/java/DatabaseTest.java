import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.*;

public class DatabaseTest {
    @Test
    public void availableBunsTest(){
        Database database = new Database();
        assertNotNull(database.availableBuns());
        assertNotEquals(0, database.availableBuns().size());
    }
    @Test
    public void availableIngredientsTest(){
        Database database = new Database();
        assertNotNull(database.availableIngredients());
        assertNotEquals(0, database.availableIngredients().size());
    }
}
