package unittests.arithmericaltests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import unittests.Configuration;

public class MultOfLongTest extends Configuration {
    @Parameters({"firstvalue", "secondvalue", "thirdvalue"})
    @Test
    public void testMultOfLong(long firstvalue, long secondvalue, long thirdvalue) throws Exception {
        long result = new Calculator().mult(firstvalue, secondvalue);
        Assert.assertEquals(result, thirdvalue, "Invalid result of mult, expected: " + thirdvalue);
    }


}
