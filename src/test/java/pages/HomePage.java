package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends PageObject {

    public static final Target LOGO_IMG = Target.the("Logo Img").located(By.cssSelector("img[alt='ID90 Travel']")),
            COMPANY_TEXT_BOX = Target.the("Company Text box").located(By.cssSelector("input#airline")),
            EMAIL_OR_NUMBER_TEXT_BOX = Target.the("Email or Employee Number Text box").located(By.cssSelector("input#airline-email-3")),
            PASSWORD_TEXT_BOX = Target.the("Password Text box").located(By.cssSelector("input#airline-password-3")),
            LOGIN_BUTTON = Target.the("Log In Button").located(By.cssSelector("button[type=submit]")),
            INVALID_CREDENTIALS_ALERT = Target.the("Log In Button").located(By.cssSelector("[role=alert]")),
            ERROR_MESSAGE = Target.the("Error Message: {0}").locatedBy("//div[@class='error-message'][contains(text(),'{0}')]"),
            SHOW_HIDE_BUTTON = Target.the("Show/Hide password button").locatedBy("//password-input//a");
}
