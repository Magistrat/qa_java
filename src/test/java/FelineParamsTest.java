import com.example.Feline;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class FelineParamsTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] {{-1}, {0}, {1}};
    }

    private final int countOfKittens;

    public FelineParamsTest (int countOfKittens){
        this.countOfKittens = countOfKittens;
    }

    @Spy
    Feline felineSpy;

    @Test
    public void getKittensAssertReturnCountTest(){
        Assert.assertEquals(countOfKittens, felineSpy.getKittens(countOfKittens));
    }

    @Test
    public void getKittensCountTimeAndArgumentTest(){
        felineSpy.getKittens(countOfKittens);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(countOfKittens);
    }
}
