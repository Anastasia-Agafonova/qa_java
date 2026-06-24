package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood, "Список еды для хищника не совпадает");
    }

    @Test
    public void testGetKittensWithoutArgsReturnsDefaultValue() {
        Feline feline = new Feline();

        int expectedKittens = 1;
        int actualKittens = feline.getKittens();

        assertEquals(expectedKittens, actualKittens, "Дефолтное количество котят должно быть равно 1");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    public void testGetKittensWithArgsReturnsCorrectValue(int kittensCount) {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens, "Метод должен возвращать переданное число котенка");
    }
    @Test
    public void testGetFamilyReturnsCorrectValue() {
        Feline feline = new Feline();

        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily, "Метод getFamily() должен возвращать 'Кошачьи'");
    }
}
