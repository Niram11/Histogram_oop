package com.codecool.histogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextReaderTest {

//    public TextReader textReader;
//    @BeforeEach
//    public void setUp() {
//        TextReader textReader = new TextReader();
//    }

    @Test
    public void testReadShouldThrowFileNotFoundExceptionWhenFileNotExists() {
        // arr
        String fileName = "/bug.txt";
        TextReader textReader = new TextReader(fileName);

        // act & assert
        assertThrows(FileNotFoundException.class, () -> textReader.read());
    }

    @ParameterizedTest
    @CsvSource({
            "src/test/resources/empty.txt, ''",
            "src/test/resources/test.txt, Harry Potter and the Sorcerer's Stone"
    })
    public void testReadShouldReturnExpectedStringWhenFileHasOneOrNoLines(String fileName, String expectedLine) throws IOException {
        // arr
        TextReader textReader = new TextReader(fileName);

        // act
        String[] result = textReader.read().split(System.lineSeparator());

        // assert
        assertEquals(1, result.length);
        assertEquals(expectedLine, result[0]);
    }

    @Test
    public void testReadShouldReturnExpectedStringWhenFileHasMoreThanOneLine() throws IOException{
        // arr
        String fileName = "src/test/resources/text.txt";
        TextReader textReader = new TextReader(fileName);

        // act
        String[] result = textReader.read().split(System.lineSeparator());

        // assert
        assertEquals(33, result.length);
    }
    
}
