package methodsDemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

public class Navigate {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#menu-item-374 > a")
    private WebElement registrationPage;

    public void homePage(WebDriver wD) {
        wD.navigate().to("http://demoqa.com/");
    }

    public void registrationPage(WebDriver wD) {
        wait.waitToLoad(wD, "#menu-item-374 > a");
        registrationPage.click();
    }
}
