package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckTriangleTest {

    @DataProvider(name = "checkTrianglePositive")
    public static Object[][] checkTrianglePositive() {
        return new Object[][]{
                {new Triangle(1, 1, 1)},
                {new Triangle(9, 12, 15)},
                {new Triangle(14, 15, 15)}
        };
    }

    @DataProvider(name = "checkTriangleNegative")
    public static Object[][] checkTriangleNegative() {
        return new Object[][]{
                {new Triangle(0, 2, 3)},
                {new Triangle(2, 0, 3)},
                {new Triangle(3, 2, 0)},
                {new Triangle(0, 0, 3)},
                {new Triangle(0, 3, 0)},
                {new Triangle(3, 0, 0)},
                {new Triangle(0, 0, 0)},
                {new Triangle(-5, 6, 7)},
                {new Triangle(6, -5, 7)},
                {new Triangle(6, 7, -5)},
                {new Triangle(-5, -6, 7)},
                {new Triangle(-5, 7, -6)},
                {new Triangle(5, -6, -7)},
                {new Triangle(-5, -6, -7)},
                {new Triangle(3, 2, 7)},
                {new Triangle(3, 7, 2)},
                {new Triangle(7, 3, 2)},
                {new Triangle(-1, 1, 1)},
                {new Triangle(2, -2, 2)},
                {new Triangle(3, 3, -3)},
                {new Triangle(0, -5, 7)},
                {new Triangle(-5, 0, 7)},
                {new Triangle(7, -5, 0)}
        };
    }

    @Test(dataProvider = "checkTrianglePositive")
    public void testCheckTrianglePositive(Triangle triangle) {
        Assert.assertTrue(triangle.checkTriangle());
    }


    @Test(dataProvider = "checkTriangleNegative")
    public void testCheckTriangleNegative(Triangle triangle) {
        Assert.assertFalse(triangle.checkTriangle());
    }


}
