package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetSquareTest {


    @DataProvider(name = "getSquareExceptions")
    public static Object[][] getSquareExceptions() {
        return new Object[][]
                {
                        {new Triangle(-5.0, 4.0, 5.0)},
                        {new Triangle(5.0, -4.0, 5.0)},
                        {new Triangle(5.0, 4.0, -5.0)},
                        {new Triangle(0.0, 5.0, 4.0)},
                        {new Triangle(5.0, 0.0, 4.0)},
                        {new Triangle(5.0, 4.0, 0.0)},
                        {new Triangle(0.0, 0.0, 0.0)},
                        {new Triangle(-5.0, -4.0, -5.0)},
                        {new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)},
                        {new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, 4.0)},
                        {new Triangle(5.0, Double.MAX_VALUE, 4.0)},
                        {new Triangle(4.0, 5.0, Double.MAX_VALUE)},

                };
    }


    @Test(expectedExceptions = Exception.class, dataProvider = "getSquareExceptions")
    public void testGetSquareExceptions(Triangle triangle) {
        triangle.getSquare();
    }


    @DataProvider(name = "getSquarePositive")
    public static Object[][] getSquarePositive() {
        return new Object[][]
                {
                        {1.73205, new Triangle(2.0, 2.0, 2.0)},
                };
    }


    @Test(dataProvider = "getSquarePositive")
    public void testGetSquare(double square, Triangle triangle) {
        Assert.assertEquals(triangle.getSquare(), square, 0.01);
    }


}

