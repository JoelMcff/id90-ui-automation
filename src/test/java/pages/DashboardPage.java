package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage extends PageObject {

    public static final Target TITTLE = Target.the("Dashboard Tittle").located(By.cssSelector("body h1"));
}
