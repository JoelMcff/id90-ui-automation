package tasks;

import actions.WriteAndSelect;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import pages.HomePage;
import testdataobjects.LoginCredentials;

public class Login {

    private static final LoginCredentials loginCredentials = LoginCredentials.getData();

    public static Performable enteringValidCredentials() {
        return Task.where("{0} enters the valid credentials",
                WriteAndSelect.theOption(loginCredentials.getCompany()).from(HomePage.COMPANY_TEXT_BOX),
                Enter.theValue(loginCredentials.getValidUsername()).into(HomePage.EMAIL_OR_NUMBER_TEXT_BOX),
                Enter.theValue(loginCredentials.getValidPassword()).into(HomePage.PASSWORD_TEXT_BOX),
                RememberThat.theValueOf("password").is(loginCredentials.getValidPassword())
        );
    }

    public static Performable enteringInvalidCredentials() {
        return Task.where("{0} enters invalid credentials",
                WriteAndSelect.theOption(loginCredentials.getCompany()).from(HomePage.COMPANY_TEXT_BOX),
                Enter.theValue(loginCredentials.getInvalidUsername()).into(HomePage.EMAIL_OR_NUMBER_TEXT_BOX),
                Enter.theValue(loginCredentials.getInvalidPassword()).into(HomePage.PASSWORD_TEXT_BOX)
        );
    }
}
