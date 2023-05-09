package utilties.utilities;

import com.github.javafaker.Faker;
import pages.AllElements;
import pages.ElementsPage;

public class BrowserTestBase {

    protected AllElements elements = new AllElements();
    protected Faker faker = new Faker();
}
