package siigo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import siigo.enums.Sites;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static siigo.ui.GooglePage.INPUT_SEARCH_GOOGLE;

public class GoToGoogle implements Task {

    private final Sites site;

    public GoToGoogle(Sites site) {
        this.site = site;
    }

    public static GoToGoogle andTo(Sites site) {
        return instrumented(GoToGoogle.class, site);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://google.com"),
                Enter.theValue(site.asString()).into(INPUT_SEARCH_GOOGLE).thenHit(Keys.ENTER)
        );

    }
}
