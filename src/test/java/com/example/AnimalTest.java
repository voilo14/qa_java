package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    @Mock
    Animal animal;

    @Test
    public void getFood() throws Exception {
        animal.getFood("Хищник");
        Mockito.verify(animal).getFood("Хищник");
    }

    @Test
    public void notFelineGetFood() throws Exception {
        animal.getFood("Травоядное");
        Mockito.verify(animal).getFood("Травоядное");
    }

    //Проверяем Exception класса Animal
    @Test
    public void animalClassException() {
        try {
            animal.getFood("Нечто");
        } catch (Exception exception) {
            Assert.assertEquals("Неизвестный вид животного", "Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
