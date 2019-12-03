package tdd;

import person.Person;

import java.util.List;

public class PersonRepository implements Repository {
    @Override
    public List<Person> getAll() {
        return List.of(new Person(42));
    }
}
