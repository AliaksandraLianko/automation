package unittests.trigonometricktests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class CtgOfDoubleTest  extends Configuration {
    @Test(dataProvider = "dataProviderForCtgOfDouble")
    public void testCtgOfDouble(double a, double expectedResult) throws Exception {
        double result = new Calculator().ctg(a);
        Assert.assertEquals(result, expectedResult, "Invalid result of sin, expected: " + expectedResult);
    }


    @DataProvider(name="dataProviderForCtgOfDouble")
    public Object[][] dataProvider() {
        return new Object[][] {
                {Math.PI/2, 0.9171523356672744},
                {3*Math.PI/2, 0.9998386139886326},
                {1, 0.7615941559557649}
        };
    }
}
