package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTestParametrized {

    private String animalKind;
    private List<String> listOfFood;

    public AnimalTestParametrized(String animalKind, List<String> listOfFood) {
        this.animalKind = animalKind;
        this.listOfFood = listOfFood;
    }
    @Before
    public  void initMockito() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public  static Object [][] setAnimalKind () {
        return new Object[][] {
                {"Травоядное",List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public  void animalGetFood() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", listOfFood, animal.getFood(animalKind));
    }
}
