package methodsDemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools.WaitClass;

public class FillForm {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#name_3_firstname")
    private WebElement forenameInput;

    @FindBy(css = "#name_3_lastname")
    private WebElement surnameInput;

    @FindBy(css = "#phone_9")
    private WebElement phoneNumberInput;

    @FindBy(css = "#email_1")
    private WebElement emailInput;

    @FindBy(css = "#profile_pic_10")
    private WebElement profilePicInput;

    @FindBy(css = "#username")
    private WebElement usernameInput;

    @FindBy(css = "#password_2")
    private WebElement passwordInput;

    @FindBy(css = "#confirm_password_password_2")
    private WebElement confirmPasswordInput;

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

    public void selectDetails(WebDriver wD, String country, String month, String day, String year) {
        Select selectCountry = new Select(wD.findElement(By.cssSelector("#dropdown_7")));
        Select selectBirthMonth = new Select(wD.findElement(By.cssSelector("#mm_date_8")));
        Select selectBirthDay = new Select(wD.findElement(By.cssSelector("#dd_date_8")));
        Select selectBirthYear = new Select(wD.findElement(By.cssSelector("#yy_date_8")));
        selectCountry.selectByValue(country);
        selectBirthMonth.selectByValue(month);
        selectBirthDay.selectByValue(day);
        selectBirthYear.selectByValue(year);
    }

    private void enterPhone(String phone) {
        phoneNumberInput.sendKeys(phone);
    }

    private void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterContactDetails(String phone, String email) {
        enterPhone(phone);
        enterEmail(email);
    }

    public void addProfilePic(Actions action, String filename) {
        profilePicInput.sendKeys("C:\\Users\\Administrator\\Pictures\\profile.jpg");
    }

    private void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void enterConfirmPassword(String password) {
        confirmPasswordInput.sendKeys(password);
    }

    public void newUser(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(password);
    }
}
