package unittests.booleantests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class NegativeTest extends Configuration {
    @Test(dataProvider = "dataProviderForIsNegative")
    public void testIsNegative(long a) {
        boolean isNegative = new Calculator().isNegative(a);
        Assert.assertTrue(isNegative, a + " is positive");
    }
    @DataProvider(name="dataProviderForIsNegative")
    public Object[][] dataProvider() {
        return new Object[][] {
                {-2},
                {-6},
                {-10}
        };
    }
}
