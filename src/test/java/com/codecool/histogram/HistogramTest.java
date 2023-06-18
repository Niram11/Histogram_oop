package com.codecool.histogram;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistogramTest {

    @Test
    public void testGetHistogramBeforeGenerateRangesReturnsEmptyHashMap() {

        //arrange
        Histogram histogram = new Histogram();
        HashMap<Range, Integer> expectedResult = new HashMap<>();

        // act
        var result = histogram.getHistogram();

        //assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void testGenerateRangesStepIsNegativeIntegerThrowIllegalArgumentException(){
        //arrange
        Histogram histogram = new Histogram();
        int step = -1;
        int amount = 1;

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> histogram.generateRanges(step, amount),
                "Step must be positive.");
    }
    @Test
    public void testGenerateRangesAmountIsNegativeIntegerThrowIllegalArgumentException(){
        //arrange
        Histogram histogram = new Histogram();
        int step = 1;
        int amount = -1;

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> histogram.generateRanges(step, amount)
                , "Amount must be positive.");
    }

    @Test
    public void testGenerateTextIsNullThrowIllegalArgumentException(){
        //arrange
        Histogram histogram = new Histogram();
        String text = null;
        List<Range> ranges = new ArrayList<>();

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> histogram.generate(text, ranges));
    }

    @Test
    public void testGenerateRangesIsNullThrowIllegalArgumentException(){
        //arrange
        Histogram histogram = new Histogram();
        String text = "asdf";
        List<Range> ranges = null;

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> histogram.generate(text, ranges));
    }

    @Test
    public void testGenerateTextIsEmptyReturnHistogram(){
        //arrange
        Histogram histogram = new Histogram();
        String text = "";
        List<Range> ranges = new ArrayList<>();
        Map<Range, Integer> expectedResult = new HashMap<>();

        //act
        var result = histogram.generate(text, ranges);

        //assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGenerateReturnsHashMap(){
        //arrange
        Histogram histogram = new Histogram();
        String text = "asdf";
        List<Range> ranges = new ArrayList<>();
        ranges.add(new Range(1,10));
        ranges.add(new Range(11,20));
        Map<Range, Integer> expectedResult = new HashMap<>();
        expectedResult.put(new Range(1,10), 1);

        //act
        var result = histogram.generate(text, ranges);

        //assert
        assertEquals(expectedResult,result);
    }

}
