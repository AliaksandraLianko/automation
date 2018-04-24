package unitTests.arithmericalTests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unitTests.Configuration;

public class SqrtOfDoubleTest extends Configuration {
    @Test(dataProvider = "dataProviderForSqrtOfDouble")
    public void testSqrtOfDouble(double a, double expectedResult) throws Exception {
        double result = new Calculator().sqrt(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of sqrt, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForSqrtOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {4, 2},
                {9, 3},
                {1, 1}
        };
    }
}
