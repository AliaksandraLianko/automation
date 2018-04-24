package unitTests.trigonometrickTests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unitTests.Configuration;

public class CosOfDoubleTest extends Configuration {
    @Test(dataProvider = "dataProviderForCosOfDouble")
    public void testCosOfDouble(double a, double expectedResult) throws Exception {
        double result = new Calculator().cos(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of sin, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForCosOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {Math.PI/2, 1},
                {3*Math.PI/2, -1},
                {0, 0}
        };
    }
}
