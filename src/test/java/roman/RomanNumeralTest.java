package roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    RomanNumeral roman;

    @BeforeEach
    void setUp(){
        roman = new RomanNumeral();
    }


    @ParameterizedTest
    @CsvSource({
            "'I', 1",
            "'V', 5",
            "'X',10",
            "'L',50",
            "'C',100",
            "'D',500",
            "'M',1000"
    })
    void singleNumber(String character, int valid) {
        assertEquals(valid, roman.convert(character));
    }


    @Test
    void numberWithManyDigits() {
        assertEquals(8, roman.convert("VIII"));
    }

    @Test
    void numberWithSubtractiveNotation() {
        assertEquals(4, roman.convert("IV"));
    }

    @Test
    void numberWithAndWithoutSubtractiveNotation() {
        assertEquals(44, roman.convert("XLIV"));
    }
}