package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void lionGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void positiveLionDoesHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void negativeLionDoesHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }
}
