package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    @Mock
    Cat cat;

    @Test
    public void catGetSound() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Кошка должна говорить - Мяу", "Мяу", cat.getSound());
    }

    @Test
    public void catGetSoundMock() {
        Mockito.when(cat.getSound()).thenReturn("Мяу");
        Assert.assertEquals("Кошка должна говорить - Мяу", "Мяу", cat.getSound());
    }

    // Прверяем метод getFood класса Cat
    @Test
    public void getFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }

    @Test
    public void negativeGetFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedCatFood = List.of("Трава", "Различные растения");
        Assert.assertNotEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }

    @Test
    public void getFoodMock2() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertNotEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }

    @Test
    public void getFoodMock() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошки - хищники", expectedCatFood, cat.getFood());
    }
}
