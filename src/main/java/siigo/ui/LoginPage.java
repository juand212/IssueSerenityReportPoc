package siigo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME = Target
            .the("username txt")
            .located(By.xpath("//label/input[@name='email']"));

    public static final Target PASSWORD = Target
            .the("password txt")
            .located(By.xpath("//label/input[@name='password']"));

    public static final Target SUBMIT = Target
            .the("enter btn")
            .located(By.xpath("//button[@type='submit']/span[contains(text(), 'Login')]"));
}
