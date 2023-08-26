import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest{

    @Spy
    Feline felineSpy;
    Feline feline = new Feline();

    @Test
    public void getFamilyAssertReturnFamilyTest(){
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getFamilyCountTimeTest(){
        felineSpy.getFamily();
        Mockito.verify(felineSpy, Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensAssertReturnCountNoArgumentTest(){
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensCountTimeNoArgumentTest(){
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens();
    }

    @Test
    public void eatMeatReturnValueEqualsTest() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(food, feline.eatMeat());
    }

    @Test
    public void eatMeatCountTimeTest() throws Exception {
        felineSpy.eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

}
