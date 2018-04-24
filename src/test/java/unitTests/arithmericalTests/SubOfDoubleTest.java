package unitTests.arithmericalTests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unitTests.Configuration;

public class SubOfDoubleTest extends Configuration {
    @Test(dataProvider = "dataProviderForSubOfDouble")
    public void testSubOfDouble(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().sub(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sub, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForSubOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3, 2, 1},
                {-6, 3, -9},
                {-1, 100, -101}
        };
    }
}
