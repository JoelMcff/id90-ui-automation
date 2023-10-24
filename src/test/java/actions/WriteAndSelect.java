package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class WriteAndSelect implements Task {

    private final Target target;
    private final String option;

    public WriteAndSelect(Target target, String option) {
        this.target = target;
        this.option = option;
    }

    public static WriteAndSelectBuilder theOption(String option) {
        return Instrumented.instanceOf(WriteAndSelectBuilder.class).withProperties(option);
    }

    @Override
    @Step("{0} writes and select the option: #option on #target")
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                JavaScriptClick.on(target),
                Enter.theValue(option).into(target),
                Hit.the(Keys.ENTER).into(target)
        );
    }

    public static class WriteAndSelectBuilder {

        private final String option;

        public WriteAndSelectBuilder(String option) {
            this.option = option;
        }

        public Performable from(Target target) {
            return Instrumented.instanceOf(WriteAndSelect.class).withProperties(target, option);
        }
    }

}
