package stepdefinitions;

import actions.WaitPage;
import actions.WriteAndSelect;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pages.DashboardPage;
import pages.HomePage;
import tasks.Login;
import tasks.ValidateElements;

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

    @And("I see the password field as {word}")
    public void SeeThePasswordFieldAs(String expectedState) {
        String passwordState = HomePage.PASSWORD_TEXT_BOX.resolveFor(theActorInTheSpotlight()).getAttribute("type");
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(passwordState).contains(expectedState)
        );
        Serenity.takeScreenshot();
    }

    @And("I click the show password button")
    public void ClickTheShowPasswordButton() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.SHOW_HIDE_BUTTON),
                WaitPage.toBeLoad()
        );
    }

    @And("I should see the password I wrote")
    public void ShouldSeeThePasswordIWrote() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(HomePage.PASSWORD_TEXT_BOX).value().isEqualTo(theActorInTheSpotlight().recall("password"))
        );
    }

    @When("I enter the invalid combination credentials {string} {string} {string}")
    public void EnterInvalidCredentialsUsernamePasswordCompany(String username, String password, String company) {
        theActorInTheSpotlight().attemptsTo(
                WriteAndSelect.theOption(company).from(HomePage.COMPANY_TEXT_BOX),
                Enter.theValue(username).into(HomePage.EMAIL_OR_NUMBER_TEXT_BOX),
                Enter.theValue(password).into(HomePage.PASSWORD_TEXT_BOX)
        );
    }

    @Then("I should see the dashboard page displayed correctly")
    public void ShouldSeeTheDashboardPageDisplayedCorrectly() {
        theActorInTheSpotlight().attemptsTo(
                ValidateElements.areDisplayedOnThe(DashboardPage.dashBoardPageElements)
        );
        Serenity.takeScreenshot();
    }
}
