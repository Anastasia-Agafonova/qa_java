package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(felineMock);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        assertEquals(expectedSound, actualSound, "Кошка должна говорить Мяу");
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood, "Список еды кошки не совпадает с ожидаемым");
    }
}
