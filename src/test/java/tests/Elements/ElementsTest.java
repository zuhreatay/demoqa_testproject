package tests.Elements;

import org.hamcrest.core.StringContains;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilties.utilities.BrowserTestBase;
import utilties.utilities.ConfigReader;
import utilties.utilities.Driver;
import utilties.utilities.ReusableMethods;

import java.util.Iterator;
import java.util.Random;

public class ElementsTest extends BrowserTestBase {

    Random random = new Random();

//   @BeforeTest
//    public void setup() {
//      Driver.getDriver().get(ConfigReader.getProperty("url"));
//        elements.getElementsPage().elementsButton.click();
//
//
//    }

    @Test
    public void elementsButton() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        elements.getElementsPage().elementsButton.click();
        elements.getElementsPage().textBox.click();
        elements.getElementsPage().userName.sendKeys(faker.name().fullName());
        elements.getElementsPage().userEmail.sendKeys(faker.internet().emailAddress());
        elements.getElementsPage().currentAddress.sendKeys(faker.address().fullAddress());
        elements.getElementsPage().permanenttAddress.sendKeys(faker.address().streetAddress());
        elements.getElementsPage().submit.click();
        String verifyTextBox = this.elements.getElementsPage().verifeyTextBox.getAttribute("class");
        System.out.println("verifyTextBox = " + verifyTextBox);
        Assert.assertTrue(elements.getElementsPage().verifeyTextBox.isDisplayed()); //?
    }

    // if we need to use dataProvider method for different class
    //@Test(dataProvider = "textBoxDataProvider",dataProviderClass= className.class)
    @Test(dataProvider = "textBoxDataProvider")
    public void negativeTest(String email) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        elements.getElementsPage().elementsButton.click();
        elements.getElementsPage().textBox.click();
        // elements.getElementsPage().userEmail.clear();
        ReusableMethods.waitFor(2);
        elements.getElementsPage().userEmail.sendKeys(email);
        elements.getElementsPage().submit.click();
        //  new AssertionError(elements.getElementsPage().verifeyEror.toString().contains("error")); That condition works but I am not sure that is correct or not
        Assert.assertTrue(elements.getElementsPage().verifeyEror.getAttribute("class").contains("error"));

    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] getData() {

        Object[][] dataList = {{"gmail.com"}, {"ayse@"}, {"ayse@gmail"}, {"@gmail.com"}};
        return dataList;
    }

    @Test
    public void checkBox() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        elements.getElementsPage().elementsButton.click();
        ReusableMethods.doubleClick(elements.getCheckBoxPage().checkBox);
        //  ReusableMethods.selectCheckBox(elements.getCheckBoxPage().checkBox.click());
        ReusableMethods.selectRandomTextFromDropdown((Select) elements.getCheckBoxPage().checkBoxButton);
        elements.getCheckBoxPage().checkIcon.click();
        Assert.assertTrue(elements.getCheckBoxPage().verifyText.getText().contains("You have selected :"));  //You have selected :
        Driver.closeDriver();

    }

//    @AfterTest
//    public void tearDown() {
//        Driver.closeDriver();
//    }


}
