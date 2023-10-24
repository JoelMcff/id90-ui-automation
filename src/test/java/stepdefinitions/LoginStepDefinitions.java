package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pages.DashboardPage;
import pages.HomePage;
import tasks.Login;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginStepDefinitions {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().the(HomePage.class),
                WaitUntil.the(HomePage.LOGO_IMG, isVisible())
        );

        Serenity.recordReportData().withTitle("URL").andContents(getDriver().getCurrentUrl());
        Serenity.takeScreenshot();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        theActorInTheSpotlight().attemptsTo(
                Login.byEnteringValidCredentials()
        );
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.LOGIN_BUTTON)
        );
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DashboardPage.TITTLE, isVisible()),
                Ensure.that(DashboardPage.TITTLE).text().contains("Begin your Next Adventure")
        );
    }

}
