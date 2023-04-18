import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getPriceReturnFloatTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Барбекю",15);
        float expected = 15;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected,actual,0.001);
    }

    @Test
    public void getNameReturnStringTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Барбекю",15);
        String expected = "Барбекю";
        String actual = ingredient.getName();
        Assert.assertEquals("Такого ингридиента нет",expected,actual);
    }

    @Test
    public void getTypeReturnIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Барбекю",15);
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Такого ингридиента нет",expected,actual);
    }
}