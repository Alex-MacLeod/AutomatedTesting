package methods;

import methods.WaitClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigate {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")
    private WebElement addUserPage;

    @FindBy(css = "td:nth-child(2) > small > a")
    private WebElement loginPage;

    public void homePage(WebDriver wD) {
        wD.navigate().to("http://thedemosite.co.uk/");
    }

    public void addUserPage(WebDriver wD) {
        wait.waitToLoad(wD, "tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)");
        addUserPage.click();
    }

    public void loginPage(WebDriver wD) {
        wait.waitToLoad(wD, "td:nth-child(2) > small > a");
        loginPage.click();
    }
}
