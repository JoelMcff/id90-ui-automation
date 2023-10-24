package stepdefinitions;

import actions.WaitPage;
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
import static utils.CollectionOfConstants.INVALID_CREDENTIALS_MESSAGE;
import static utils.CollectionOfConstants.WELCOME_TITTLE;

public class LoginStepDefinitions {

    @Given("I am on the home page")
    public void onTheHomePage() {
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().the(HomePage.class),
                WaitPage.toBeLoad()
        );

        Serenity.recordReportData().withTitle("URL").andContents(getDriver().getCurrentUrl());
        Serenity.takeScreenshot();
    }

    @When("I enter valid credentials")
    public void enterValidCredentials() {
        theActorInTheSpotlight().attemptsTo(
                Login.enteringValidCredentials()
        );
    }

    @When("I enter invalid credentials")
    public void enterInvalidCredentials() {
        theActorInTheSpotlight().attemptsTo(
                Login.enteringInvalidCredentials()
        );
    }

    @And("I click the login button")
    public void clickTheLoginButton() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.LOGIN_BUTTON)
        );
    }

    @Then("I should be logged in")
    public void ShouldBeLoggedIn() {
        theActorInTheSpotlight().attemptsTo(
                WaitPage.toBeLoad(),
                Ensure.that(DashboardPage.TITTLE).text().contains(WELCOME_TITTLE)
        );
        Serenity.takeScreenshot();
    }


    @Then("I should see an alert")
    public void ShouldSeeAnAlert() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.INVALID_CREDENTIALS_ALERT, isVisible()),
                Ensure.that(HomePage.INVALID_CREDENTIALS_ALERT).text().contains(INVALID_CREDENTIALS_MESSAGE)
        );
        Serenity.takeScreenshot();
    }

    @Then("I should see an error message that reads {string}")
    public void shouldSeeAnErrorMessageThatReads(String message) {
        theActorInTheSpotlight().attemptsTo(
                WaitPage.toBeLoad(),
                Ensure.that(HomePage.ERROR_MESSAGE.of(message)).isDisplayed()
        );
        Serenity.takeScreenshot();
    }
}
