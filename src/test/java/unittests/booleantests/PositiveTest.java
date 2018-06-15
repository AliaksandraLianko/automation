package unittests.booleantests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import unittests.Configuration;

public class PositiveTest extends Configuration {
    @Test(dataProvider = "dataProviderForIsPositive")
    public void testIsPositive(long a) {
        boolean isPositive = new Calculator().isPositive(a);
        Assert.assertTrue(isPositive, a + " is positive");
    }
    @DataProvider(name="dataProviderForIsPositive")
    public Object[][] dataProvider() {
        return new Object[][] {
                {2},
                {6},
                {1}
        };
    }
}
