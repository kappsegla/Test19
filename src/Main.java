import java.security.AllPermission;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class Main {
    public static void main(String[] args) {

        var d = Arrays.stream(args).mapToDouble(Double::parseDouble).toArray();

        Triangle triangle = new Triangle(d);

        if (triangle.isScalene())
            System.out.println("Oliksidig triangel.");
        else if (triangle.isEquilateral())
            System.out.println("Liksidig triangel, 3 sidor av samma längd.");
        else if( triangle.isIsosceles())
            System.out.println("Likbent triangel, 2 sidor med samma längd.");
        else
            throw new IllegalArgumentException();
    }
}
