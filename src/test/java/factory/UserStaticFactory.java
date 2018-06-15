package factory;

import businessobjects.User;

public class UserStaticFactory {

    public static User createNominator() {
        User user = new User();
        user.setUsername("norma_nominator");
        user.setPassword("pass");
        return user;
    }

    public static User createApprover() {
        User user = new User();
        user.setUsername("manfred_manager2");
        user.setPassword("pass");
        return user;
    }
}
