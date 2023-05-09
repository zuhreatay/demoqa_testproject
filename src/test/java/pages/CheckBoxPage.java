package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilties.utilities.Driver;

import java.util.List;

public class CheckBoxPage {


    public CheckBoxPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Check Box']")
    public WebElement checkBox;
    @FindBy(xpath = "//span[@class='rct-title']")
    public WebElement checkIcon;
    @FindBy(xpath = "//button[@title='Toggle']")
    public List<WebElement> checkBoxButton;
    @FindBy(xpath = "//span[text()='You have selected :']")
    public WebElement verifyText;
}
