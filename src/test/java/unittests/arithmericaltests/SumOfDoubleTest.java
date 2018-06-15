package unittests.arithmericaltests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class SumOfDoubleTest extends Configuration {
    @Test(dataProvider = "dataProviderForSumOfDouble")
    public void testSumOfDouble(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().sum(a,b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sum, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForSumOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3, 2, 5},
                {-6, 3, -3},
                {-1, 100, 99}
        };
    }
}
