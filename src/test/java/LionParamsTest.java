import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;


@RunWith(Parameterized.class)
public class LionParamsTest {
    private final String sex;
    private final boolean expectedResult;
    public LionParamsTest(String sex, boolean expectedResult){
        this.sex = sex;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Spy
    Feline felineSpy;

    Lion lion;
    Lion lionSpy;

    @Test
    public void doesHaveManeAssertReturnEqualsTest() throws Exception{
        lion = new Lion(sex, new Feline());
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }

    @Test
    public void getKittensAssertReturnEqualsTest() throws Exception{
        lion = new Lion(sex, new Feline());
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getKittensCountTimeEqualsTest() throws Exception{
        lionSpy = new Lion(sex, felineSpy);
        lionSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodAssertReturnEqualsTest() throws Exception {
        lion = new Lion(sex, new Feline());
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void getFoodCountTimeEqualsTest() throws Exception{
        lionSpy = new Lion(sex, felineSpy);
        lionSpy.getFood();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

}
