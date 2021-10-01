package siigo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target LOGOUT = Target
            .the("button logout")
            .located(By.id("logout"));
}
