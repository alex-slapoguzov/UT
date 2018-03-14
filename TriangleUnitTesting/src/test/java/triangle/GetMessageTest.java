package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetMessageTest {


    @DataProvider(name = "getMessage")
    public static Object[][] getMessage() {
        return new Object[][]{
                {"a+b<=c", new Triangle(1, 2, 4)},
                {"b+c<=a", new Triangle(7, 2, 3)},
                {"a+c<=b", new Triangle(3, 12, 6)},
                {"a<=0", new Triangle(-3, -4, -5)},
                {"a<=0", new Triangle(-3, 4, 5)},
                {"b<=0", new Triangle(3, -4, 5)},
                {"c<=0", new Triangle(3, 4, -5)},
                {"a<=0", new Triangle(0, 0, 0)},
                {"a<=0", new Triangle(0, 4, 5)},
                {"b<=0", new Triangle(4, 0, 5)},
                {"c<=0", new Triangle(4, 5, 0)},
        };
    }


    @Test
    public void testCheckDefaultMessage() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), "");
    }


    @Test(dataProvider = "getMessage")
    public void testCheckMessage(String message, Triangle triangle) {
        triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), message);
    }
}
