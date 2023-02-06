package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Кошачьи - хищники", expectedFelineFood, feline.eatMeat());
    }

    @Test
    public void getFood() throws Exception {
        feline.getFood("Хищник");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void notFelineGetFood() throws Exception {
        feline.getFood("Травоядное");
        Mockito.verify(feline).getFood("Травоядное");
    }

    //Проверяем метод getFamily класса Feline
    @Test
    public void getFamily() {
        Feline feline = new Feline();
        Assert.assertNotEquals("Это семейство Кошачьи", "Псовые", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int felineKittens = 1;
        Assert.assertEquals("У кошачьх 1 котенок", felineKittens, feline.getKittens());
    }

    @Test
    public void getFamilyMock() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals("Это семейство Кошачьи", "Кошачьи", feline.getFamily());
    }
}
