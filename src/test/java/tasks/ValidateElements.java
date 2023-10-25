package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;


import java.util.List;

public class ValidateElements {

    public static Performable areDisplayedOnThe(List<Target> allTargets) {
        return Task.where("{0} Validate elements are displayed",
                actor -> {
                    for (Target element : allTargets) {
                        actor.attemptsTo(
                                Ensure.that(element).isDisplayed()
                        );
                    }
                });
    }
}
