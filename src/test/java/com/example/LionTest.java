package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetKittensReturnsCorrectCount() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");

        Mockito.when(felineMock.getKittens()).thenReturn(1);

        int actualKittens = lion.getKittens();

        assertEquals(1, actualKittens, "Количество котят должно соответствовать значению из Feline");
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion (felineMock, "Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood, "Список еды льва не совпадает с ожидаемым");
    }

    @Test
    public void testLionConstructorThrowsExceptionOnInvalidSex() {
        try {
            new Lion(felineMock, "НеизвестныйПол");
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
