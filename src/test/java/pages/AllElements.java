package pages;

import org.openqa.selenium.support.PageFactory;
import utilties.utilities.Driver;

public class AllElements {

    private ElementsPage elementsPage;
    private CheckBoxPage checkBoxPage;

    public CheckBoxPage getCheckBoxPage() {
        return checkBoxPage;
    }

    public ElementsPage getElementsPage() {
        if (elementsPage == null) {
            elementsPage = new ElementsPage();
        }
        return elementsPage;
    }

}
