package tasks;

import actions.WriteAndSelect;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import pages.HomePage;
import testdataobjects.UserCredentials;

public class Login {

    private static final UserCredentials userCredentials = UserCredentials.getData();

    public static Performable byEnteringValidCredentials() {
        return Task.where("{0} enters the valid credentials",
                WriteAndSelect.theOption(userCredentials.getCompany()).from(HomePage.COMPANY_TEXT_BOX),
                Enter.theValue(userCredentials.getValidUsername()).into(HomePage.EMAIL_OR_NUMBER_TEXT_BOX),
                Enter.theValue(userCredentials.getValidPassword()).into(HomePage.PASSWORD_TEXT_BOX)
        );
    }
}
