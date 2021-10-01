package siigo.features.login;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import siigo.tasks.LoginWith;
import siigo.ui.HomePage;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@RunWith(SerenityRunner.class)
@Narrative(text = {"In order to ....",
        "As a ....",
        "I want to be able to ...."})
@WithTag("login")
public class Login {

    @Managed
    WebDriver chrome;

    Actor rafael;

    @Before
    public void setup() {
        chrome.manage().window().maximize();
        rafael = Actor.named("Rafael");
        rafael.whoCan(BrowseTheWeb.with(chrome));
        rafael.attemptsTo(
                Open.url("https://phptravels.net/api/admin")
        );

    }

    @Test
    public void should_UserLoginSuccessfully_When_HeSendsValidCredentials()  {
        rafael.attemptsTo(
                LoginWith.username("admin@phptravels.com")
                        .andPassword("demoadmin")
        );
        rafael.should(
                seeThat("the displayed logout", the(HomePage.LOGOUT.waitingForNoMoreThan(Duration.ofSeconds(5))), isVisible())
        );
    }

}
