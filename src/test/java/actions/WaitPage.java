package actions;

import lombok.SneakyThrows;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WaitPage implements Task {

    public static Performable toBeLoad() {
        return Instrumented.instanceOf(WaitPage.class).newInstance();
    }

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T t) {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) Objects.requireNonNull(wd)).executeScript("return document.readyState").equals("complete"));

    }
}
