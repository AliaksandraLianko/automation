package unittests.trigonometricktests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class SinOfDoubleTest  extends Configuration {
    @Test(dataProvider = "dataProviderForSinOfDouble")
    public void testSinOfDouble(double a, double expectedResult) throws Exception {
        double result = new Calculator().sin(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of sin, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForSinOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {Math.PI/2, 1},
                {3*Math.PI/2, -1},
                {0, 0}
        };
    }
}
