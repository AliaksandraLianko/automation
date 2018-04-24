package unitTests.arithmericalTests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unitTests.Configuration;

public class DivOfLongTest extends Configuration {
    @Test(dataProvider = "dataProviderForDivOfLong", groups = {"arithmetics", "regression"})
    public void testDivOfLong(long a, long b, long expectedResult) throws Exception {
        long result = new Calculator().mult(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of div, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForDivOfLong")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3L, 2L, 6L},
                {-6, 3, -18},
                {-1, 100, -100}
        };
    }
}
