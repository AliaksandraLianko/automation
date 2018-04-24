package unitTests.arithmericalTests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unitTests.Configuration;

public class SumOfLongTest extends Configuration {
    @Test(dataProvider = "dataProviderForSumOfLong")
    public void testSumOfLong(long a, long b, long expectedResult) throws Exception {
        long result = new Calculator().sum(a,b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sum, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForSumOfLong")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3L, 2L, 5L},
                {-6, 3, -3},
                {-1, 100, 99}
        };
    }
}
