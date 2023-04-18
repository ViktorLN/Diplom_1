import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Test
    public void setBunsReturnBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        MatcherAssert.assertThat(this.bun, notNullValue());
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        int actual = burger.ingredients.size();
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);
        Ingredient expected = firstIngredient;
        Ingredient actual = burger.ingredients.get(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        float expected = 400F;
        float actual = burger.getPrice();
        Assert.assertEquals(expected,actual,0.001);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Sesame");
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("= %s =%n","sauce hot sauce"));
        expectedReceipt.append(String.format("= %s =%n","sauce sour cream"));
        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
