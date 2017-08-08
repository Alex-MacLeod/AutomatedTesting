package methods;

import methods.WaitClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigate {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > " +
            "td:nth-child(2) > p > small > a:nth-child(6)")
    private WebElement addUserPage;

    @FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > " +
            "td:nth-child(2) > p > small > a:nth-child(7)")
    private WebElement loginPage;

    public void homePage(WebDriver wD) {
        wD.navigate().to("http://thedemosite.co.uk/");
    }

    public void addUserPage(WebDriver wD) {
        wait.waitToLoad(wD, "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > " +
                "tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)");
        addUserPage.click();
    }

    public void loginPage(WebDriver wD) {
        wait.waitToLoad(wD, "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > " +
                "tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)");
        loginPage.click();
    }
}
