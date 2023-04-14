import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.*;


@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;
    private final boolean expectError;

    public BunParameterizedTest(String name, float price, boolean expectError) {
        this.name = name;
        this.price = price;
        this.expectError = expectError;
    }

    @Parameterized.Parameters
    public static Object [][] getBunDate() throws IllegalArgumentException {
        return new Object[][] {
                {null, 99999F, true},
                { "white bun", 0 , false},
                { "red bun", -5F, true},
                { null, -55F, true},
                { "black bun", 25F, false},
        };
    }

    @Test
    public void creatingBunTest(){
        Bun bun = new Bun(name,price);
        if (expectError){
            MatcherAssert.assertThat("Обьект с неприемлимыми параметрами был создан"
                    ,bun, is((notNullValue())));
        }
        else {
            MatcherAssert.assertThat("Обьект не был создан",bun, notNullValue());
        }
    }
}
