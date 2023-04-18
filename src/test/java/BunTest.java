import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameReturnStringTest() {
        Bun bun = new Bun("Черная", 50);
        String expected = "Черная";
        String actual = bun.getName();
        Assert.assertEquals("Такой булочки нет",expected,actual);
    }

    @Test
    public void getPriceReturnFloatTest() {
        Bun bun = new Bun("Черная", 50);
        float expected = 50;
        float actual = bun.getPrice();
        Assert.assertEquals(expected,actual,0.001);
    }

}