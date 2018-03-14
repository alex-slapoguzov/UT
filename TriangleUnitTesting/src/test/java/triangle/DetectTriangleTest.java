package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.StrictMath.sqrt;

public class DetectTriangleTest {

    @DataProvider(name = "detectTriangle")
    public static Object[][] detectTriangle() {
        return new Object[][]{
                {8, new Triangle(5.0, 4.0, 3.0)},
                {8, new Triangle(4.0, 5.0, 3.0)},
                {8, new Triangle(3.0, 4.0, 5.0)},
                {1, new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)},
                {2, new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, 5.0)},
                {8, new Triangle(4.0, 4.0, 4*sqrt(2.0))},
                {8, new Triangle(4.0, 4*sqrt(2.0), 4.0)},
                {8, new Triangle(4*sqrt(2.0), 4.0, 4.0)},
                {1, new Triangle(5.0, 5.0, 5.0)},
                {4, new Triangle(6.0, 4.0, 5.0)},
        };
    }

    @DataProvider(name = "detectTriangleExceptions")
    public static Object[][] detectTriangleException() {
        return new Object[][]{
                {new Triangle(0.0, 0.0, 0.0)},
                {new Triangle(-6.0, -4.0, -5.0)},
                {new Triangle(-6.0, 4.0, 5.0)},
                {new Triangle(6.0, -4.0, 5.0)},
                {new Triangle(6.0, 4.0, -5.0)},
                {new Triangle(0.0, 4.0, 5.0)},
                {new Triangle(6.0, 0.0, 5.0)},
                {new Triangle(6.0, 4.0, 0.0)},
        };
    }


    @Test(dataProvider = "detectTriangle")
    public void testDetectTriangle(int final_state, Triangle triangle){
        Assert.assertEquals(triangle.detectTriangle(), final_state);
    }


    @Test(expectedExceptions = Exception.class, dataProvider = "detectTriangleExceptions")
    public void testDetectTriangleExceptions(Triangle triangle){
        triangle.detectTriangle();
    }

}
