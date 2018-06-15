package unittests.arithmericaltests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class SubOfLongTest extends Configuration {
    @Test(dataProvider = "dataProviderForSubOfLong", groups = {"arithmetics"})
    public void testSubOfLong(long a, long b, long expectedResult) throws Exception {
        long result = new Calculator().sub(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sub, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForSubOfLong")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3L, 2L, 1L},
                {-6, 3, -9},
                {-1, 100, -101}
        };
    }
}
