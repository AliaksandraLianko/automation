package unittests.arithmericaltests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import unittests.Configuration;

public class MultOfDoubleTest extends Configuration {
    @Parameters({"firstvalue", "secondvalue", "thirdvalue"})
    @Test
    public void testMultOfDouble(double firstvalue, double secondvalue, double thirdvalue) throws Exception {
        double result = new Calculator().mult(firstvalue, secondvalue);
        Assert.assertEquals(result, thirdvalue, "Invalid result of mult, expected: " + thirdvalue);
    }
}
