package siigo.features.documents.debitnote.sales;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import siigo.enums.Sites;
import siigo.tasks.GoToGoogle;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static siigo.ui.GooglePage.LINK_RESULT;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a siigo user",
        "I want to create a debit notes (sales)",
        "to be able to modify the sales record"})
@WithTagValuesOf({"debit-note","sales"})
public class DebitNoteSalesWithTaxes {

    @Managed
    WebDriver chrome;

    Actor rafael;

    @Before
    public void setup() {
        chrome.manage().window().maximize();
        rafael = Actor.named("Rafael");
        rafael.whoCan(BrowseTheWeb.with(chrome));
    }

    @Test
    public void testDebitNoteSaleWithTaxes()  {
        rafael.attemptsTo(
                GoToGoogle.andTo(Sites.DEBIT_NOTE_SALES)
        );
        rafael.should(
                seeThat("the displayed result", the(LINK_RESULT.waitingForNoMoreThan(Duration.ofSeconds(5))), isVisible())
        );
    }
}
