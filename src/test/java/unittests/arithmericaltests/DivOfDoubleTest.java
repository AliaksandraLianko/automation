package unittests.arithmericaltests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class DivOfDoubleTest extends Configuration {
    @Test(groups = {"arithmetics"}, dataProvider = "dataProviderForDivOfDouble")
    public void testDivOfDouble(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().mult(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of div, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForDivOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3L, 2L, 6L},
                {-6, 3, -18},
                {-1, 100, -100}
        };
    }
}
