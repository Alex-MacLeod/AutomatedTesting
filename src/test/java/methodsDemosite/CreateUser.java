package methodsDemosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

public class CreateUser {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "td:nth-child(2) > p > input")
    private WebElement usernameInput;

    @FindBy(css = "tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    private WebElement saveButton;

    private void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void save() {
        saveButton.click();
    }

    public void createUser(WebDriver wD, String username, String password) {
        wait.waitToLoad(wD, "td:nth-child(2) > p > input");
        enterUsername(username);
        wait.waitToLoad(wD, "tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]");
        enterPassword(password);
        wait.waitToLoad(wD, "tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]");
        save();
    }

}
