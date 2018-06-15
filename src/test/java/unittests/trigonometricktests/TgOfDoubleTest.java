package unittests.trigonometricktests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class TgOfDoubleTest extends Configuration {
        @Test(dataProvider = "dataProviderForTgOfDouble")
        public void testTgOfDouble(double a, double expectedResult) throws Exception {
            double result = new Calculator().tg(a);
            Assert.assertEquals(result, expectedResult, "Invalid result of sin, expected: " + expectedResult);
        }


        @DataProvider(name="dataProviderForTgOfDouble")
        public Object[][] dataProvider() {
            return new Object[][] {
                    {Math.PI/2, 1},
                    {3*Math.PI/2, 1},
                    {1, 1}
            };
        }
}
