import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {


    @Test
    @DisplayName("isScalene should return true for a scalene triangle.")
    void isScaleneReturnsTrueForScaleneTriangle() {
        //Arrange
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        //Act
        boolean scalene = triangle.isScalene();

        //Assert
        assertTrue(scalene,"Failed to identify scalene triangle. ");
    }

    @Test
    void isScaleneReturnsFalseForTriangleWithTwoEqualSides() {
        //Arrange
        Triangle triangle = new Triangle(3.0, 3.0, 5.0);

        //Act
        boolean scalene = triangle.isScalene();

        //Assert
        assertFalse(scalene);
    }

    @Test
    void constructorWithPointArgumentsCreatesTriangleWithSidesOfRightLength()
    {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,4);
        Point p3 = new Point(5,1);
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(p1,p2,p3);
        assertArrayEquals(sides, triangle.sides);
    }

    @Test
    void constructorWithPointArrayCreatesTriangleWithSidesOfRightLength()
    {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,4);
        Point p3 = new Point(5,1);
        Point[] points = {p1, p2, p3};
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(points);
        assertArrayEquals(sides, triangle.sides);
    }
}