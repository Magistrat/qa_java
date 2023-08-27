import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Feline felineSpy;
    Cat cat;

    @Test
    public void getSoundAssertReturnValueEqualsTest(){
        cat = new Cat(new Feline());
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodAssertReturnValueEqualsTest() throws Exception{
        cat = new Cat(new Feline());
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(food, cat.getFood());
    }

    @Test
    public void getFoodCountTimesAndArgumentTest() throws Exception{
        cat = new Cat(felineSpy);
        cat.getFood();
        Mockito.verify(felineSpy, Mockito.times(1)).eatMeat();
        Mockito.verify(felineSpy, Mockito.times(1)).getFood("Хищник");
    }

}
