package unittests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Configuration {
    Calculator calculator;

    @BeforeSuite
    public void beforeClass() {
        System.out.println("@BeforeSuite: I run only once, before first test start.");
        calculator = new Calculator();
    }

    @AfterSuite
    public void afterClass() {
        System.out.println("@AfterSuite: I run only once, after all tests have been done.\n");
        calculator = null;
    }

}
