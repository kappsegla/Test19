import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import person.Person;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @ParameterizedTest
    @CsvSource({
            "17, false",
            "21, true"})
    public void personIsAdult(int age, boolean valid) throws Exception {
        //assertEquals(new Person(age).isAdult(), valid);
    }
}
