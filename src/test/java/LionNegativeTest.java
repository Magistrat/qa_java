import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionNegativeTest {
    @Parameterized.Parameters
    public static Object[][] getWrongSex(){
        return new Object[][] {
                {"1"},
                {"-1"},
                {""},
                {" "},
                {"Samets"},
                {"Samka"},
                {"Самец "},
                {"Самка "}
        };
    }
    private final String invalidSex;

    public LionNegativeTest(String invalidSex){
        this.invalidSex = invalidSex;
    }

    @Test(expected = Exception.class)
    public void lionConstructorNegativeTest() throws Exception {
        new Lion(invalidSex, new Feline());
    }

}
