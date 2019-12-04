package person;

public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public boolean isAdult() {
        if( age >= 18)
            return true;
        return false;
    }
}
