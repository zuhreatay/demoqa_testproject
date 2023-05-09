package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilties.utilities.BrowserTestBase;
import utilties.utilities.Driver;

public class ElementsPage extends BrowserTestBase {


    public ElementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    public WebElement elementsButton;
    @FindBy(xpath = "//span[.='Text Box']")
   public WebElement textBox;
    @FindBy(id = "userName")
    public WebElement userName;
    @FindBy(id = "userEmail")
    public WebElement userEmail;
    @FindBy(id = "currentAddress")
    public WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    public WebElement permanenttAddress;
    @FindBy(id = "submit")
    public WebElement submit;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
    public WebElement verifeyTextBox;
    @FindBy(xpath = "//input[@class='mr-sm-2 field-error form-control']")
    public WebElement verifeyEror;




}
