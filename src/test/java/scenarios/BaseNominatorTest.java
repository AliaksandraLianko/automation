package scenarios;

import businessobjects.User;
import factory.UserStaticFactory;
import org.testng.annotations.BeforeClass;
import services.LoginService;


public class BaseNominatorTest extends BaseTest {

    @BeforeClass
    public void login() {
        User nominator = UserStaticFactory.createNominator();
        LoginService loginService = new LoginService(getDriver());
        loginService.loginToApp(nominator);
    }
}
