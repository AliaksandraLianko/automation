package unittests.arithmericaltests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class PowOfDoubleTest  extends Configuration {
    @Test(dataProvider = "dataProviderForPowOfDouble", groups = {"trigonometricks"})
    public void testPowOfDouble(double a, double b, double expectedResult) throws Exception {
        double result = new Calculator().pow(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid result of sum, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForPowOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {3, 2, 9},
                {-6, 3, -216},
                {-1, 100, 1}
        };
    }
}
