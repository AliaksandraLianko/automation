package scenarios;

import businessobjects.User;
import factory.UserStaticFactory;
import org.testng.annotations.BeforeClass;
import services.LoginService;

public class BaseApproverTest extends BaseTest{

        @BeforeClass
        public void login() {
            User approver = UserStaticFactory.createApprover();
            LoginService loginService = new LoginService(getDriver());
            loginService.loginToApp(approver);
        }
    }


