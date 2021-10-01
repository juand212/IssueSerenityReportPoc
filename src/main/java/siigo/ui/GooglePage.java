package siigo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class GooglePage {

    public static final Target INPUT_SEARCH_GOOGLE = Target.the("search of google").locatedBy("//div[@class='SDkEP']/div[2]/input");
    public static final Target LINK_RESULT = Target.the("first result").locatedBy("(//h3[@class='LC20lb DKV0Md'])[1]");

}
