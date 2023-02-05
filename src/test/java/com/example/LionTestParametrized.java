package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionTestParametrized {
    private  String sex;
    private boolean hasMane;

    private int kittensCount;

    public LionTestParametrized(String sex, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Before
    public  void initMockito() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public  static Object [][] setLionSex () {
        return new Object[][] {
                {"Самец", true, 1},
                {"Самка", false, 1}
        };
    }

    @Test
    public  void lionDoesHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);

        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", hasMane, lion.doesHaveMane());
    }

    @Test
    public void lionGetKittens() throws  Exception{
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);

        Assert.assertEquals("У львов 1 львенок", kittensCount, lion.getKittens());
    }
}
