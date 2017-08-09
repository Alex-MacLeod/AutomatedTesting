package methodsDemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

public class EnterName {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#name_3_firstname")
    private WebElement forenameInput;

    @FindBy(css = "#name_3_lastname")
    private WebElement surnameInput;

    private void enterForename(String forename) {
        forenameInput.sendKeys(forename);
    }

    private void enterSurname(String surname) {
        surnameInput.sendKeys(surname);
    }

    public void enterName(WebDriver wD, String forename, String surname) {
        wait.waitToLoad(wD, "#name_3_firstname");
        enterForename(forename);
        wait.waitToLoad(wD, "#name_3_lastname");
        enterSurname(surname);
    }
}
