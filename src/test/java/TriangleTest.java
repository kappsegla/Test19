import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    private final Triangle scaleneTriangle = new Triangle(3.0, 4.0, 5.0);
    private final Triangle isoTriangle = new Triangle(3.0, 3.0, 4.0);
    private final Triangle equTriangle = new Triangle(3.0, 3.0, 3.0);

    @Test
    @DisplayName("isScalene should return true for a scalene triangle.")
    void isScaleneReturnsTrueForScaleneTriangle() {
        //Act
        boolean scalene = scaleneTriangle.isScalene();

        //Assert
        assertTrue(scalene, "Failed to identify scalene triangle. ");
    }

    @Test
    void isScaleneReturnsFalseForTriangleWithTwoEqualSides() {
        //Act
        boolean scalene = isoTriangle.isScalene();

        //Assert
        assertFalse(scalene);
    }

    @Test
    void isIsoscelesReturnsTrueForIsoTriangle() {
        //Act
        boolean iso = isoTriangle.isIsosceles();

        //Assert
        assertTrue(iso, "Failed to identify scalene triangle. ");
    }

    @Test
    void isIsoscelesReturnsFalseForEquilateralTriangle() {
        //Act
        boolean iso = equTriangle.isIsosceles();

        //Assert
        assertFalse(iso);
    }

    @Test
    void isEquilateralReturnsTrueForEquilateralTriangle() {
        //Act
        boolean equ = equTriangle.isEquilateral();

        //Assert
        assertTrue(equ);
    }

    @Test
    void isEquilateralReturnsFalseForIsoTriangle() {
        //Act
        boolean equ = isoTriangle.isEquilateral();

        //Assert
        assertFalse(equ);
    }

    @Test
    void constructorWithPointArgumentsCreatesTriangleWithSidesOfRightLength() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(5, 1);
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(p1, p2, p3);
        assertArrayEquals(sides, triangle.sides);
    }

    @Test
    void constructorWithPointArrayCreatesTriangleWithSidesOfRightLength() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(5, 1);
        Point[] points = {p1, p2, p3};
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(points);
        assertArrayEquals(sides, triangle.sides);
    }

    @Test
    void constructorWithLengthArray() {
        double[] sides = {3.0, 5.0, 4.0};

        Triangle triangle = new Triangle(sides);
        assertArrayEquals(sides, triangle.sides);
    }
}