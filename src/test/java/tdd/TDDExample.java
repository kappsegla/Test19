package tdd;

import org.junit.jupiter.api.Test;
import person.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TDDExample {

    @Test
    void retrieveListOfAllPersonsFromPersonRepository() {
        Repository personRepository = new PersonRepository();

        List<Person> personList = personRepository.getAll();

        assertEquals(1,personList.size(),"Wrong number of persons in list.");

    }
}
