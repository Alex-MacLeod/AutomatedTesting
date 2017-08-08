package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > " +
            "td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    private WebElement usernameInput;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > " +
            "td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > " +
            "input[type=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]" +
            "/td[2]/p/input")
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
        wait.waitToLoad(wD, "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr " +
                "> td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input");
        enterUsername(username);
        wait.waitToLoad(wD, "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > " +
                "tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p " +
                "> input[type=\"password\"]");
        enterPassword(password);
        wait.waitToLoad(wD, "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody " +
                "> tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > " +
                "input[type=\"button\"]");
        save();
    }

}
