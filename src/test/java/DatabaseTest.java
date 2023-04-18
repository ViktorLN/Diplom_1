import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        MatcherAssert.assertThat(database.availableBuns(), notNullValue());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        MatcherAssert.assertThat(database.availableIngredients(), notNullValue());
    }
}