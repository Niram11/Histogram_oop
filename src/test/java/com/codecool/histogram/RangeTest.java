package com.codecool.histogram;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {
    @Test
    public void testWhenFromIsLessThan0ThrowIllegalArgumentException() {
        // arrange
        int to = 4;
        int from = -6;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Range(from, to));
    }

    @Test
    public void testWhenToIsLessThanFromThrowIllegalArgumentException() {
        // arrange
        int to = 2;
        int from = 8;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> new Range(from, to));
    }

    @Test
    public void testWhenArgumentAreCorrectDoesNotThrowIllegalArgumentExceptionAndObjectWasCreated()
    {
        // arrange
        int from = 5;
        int to = 8;

        // act & assert
        assertDoesNotThrow(() -> new Range(from, to));

        Range range = new Range(from, to);
        assertNotNull(range);
    }

//    public boolean isInRange(String word) {
//        return word.length() >= from && word.length() <= to;
//    }

    // + word is in range
    // + word length less than range
    // + word length is greater than range
    // - word is null
    // + word length is equal to "to".
    // + word length is equal to "from".


    @ParameterizedTest
    @CsvSource({
            "2, 7, true",
            "7, 10, false",
            "6, 10, true",
            "4, 6, true",
            "2, 4, false"
    })
    public void testWhenSpecificParametersShouldReturnExpectedBoolean(int from, int to, boolean expectedResult)
    {
        // arrange
        String word = "abcdef";
        Range range = new Range(from, to);

        // act
        boolean isInRange = range.isInRange(word);

        // assert
        assertEquals(expectedResult, isInRange);
    }

    @Test
    public void tesWhenWordIsNullAndNullReferencesExceptionWasThrow() {
        // arrange
        int from = 5;
        int to = 7;
        Range range = new Range(from, to);

        // act & assert
        assertThrows(NullPointerException.class, () -> range.isInRange(null));
    }

    @ParameterizedTest
    @CsvSource({
            "11, 15, '11 - 15'",
            "7, 9, '7  - 9 '"
    })
    public void testToStringShouldReturnExpectedString(int from, int to, String expectedResult)
    {
        // arrange
        Range range = new Range(from, to);

        // act
        String resultString = range.toString();

        // assert
        assertEquals(expectedResult, resultString);
    }
}
