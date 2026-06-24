package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(felineMock);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittensAlwaysReturnsZero() throws Exception {
        Alex alex = new Alex(felineMock);
        assertEquals(0, alex.getKittens());
    }
    @Test
    public void testAlexAlwaysHasMane() throws Exception {
        Alex alex = new Alex(felineMock);
        assertTrue(alex.doesHaveMane());
    }
}
