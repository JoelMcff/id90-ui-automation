package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class DashboardPage extends PageObject {

    public static final Target TITTLE = Target.the("Dashboard Tittle").located(By.cssSelector("body h1")),
                               SEARCH_PANEL = Target.the("Search panel").locatedBy("//div[@class='row d-flex']"),
                               HEADER_NAV_BAR = Target.the("Header Nav bar").locatedBy("//nav[@id='mainNavBar']"),
                               USER_MENU = Target.the("User Menu").locatedBy("[data-cy=userMenu]"),
                               FOOTER = Target.the("Footer").locatedBy("//div[@class='row h-100 py-5']"),
                               CONTACT_US_SECTION = Target.the("Footer").locatedBy("//h5[text()='Contact Us']/.."),
                               PHONE = Target.the("Phone").locatedBy("//h5[text()='Contact Us']/../a[contains(@href,'tel')]"),
                               MAIL = Target.the("E-Mail").locatedBy("//h5[text()='Contact Us']/../a[contains(@href,'mail')]");

    public static final List<Target> dashBoardPageElements = Arrays.asList(
            TITTLE,
            SEARCH_PANEL,
            HEADER_NAV_BAR,
            USER_MENU,
            FOOTER,
            CONTACT_US_SECTION,
            PHONE,
            MAIL
    );

}
