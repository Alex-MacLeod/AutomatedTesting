package methodsDemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

public class Navigate {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#menu-item-374 > a")
    private WebElement registrationPage;

    @FindBy(css = "#menu-item-140 > a")
    private WebElement draggablePage;

    @FindBy(css = "#menu-item-141 > a")
    private WebElement droppablePage;

    @FindBy(css = "#menu-item-151 > a")
    private WebElement sortablePage;

    public void homePage(WebDriver wD) {
        wD.navigate().to("http://demoqa.com/");
    }

    public void registrationPage(WebDriver wD) {
        wait.waitToLoad(wD, "#menu-item-374 > a");
        registrationPage.click();
    }

    public void draggablePage(WebDriver wD) {
        wait.waitToLoad(wD, "#menu-item-140 > a");
        draggablePage.click();
    }

    public void droppablePage(WebDriver wD) {
        wait.waitToLoad(wD, "#menu-item-141 > a");
        droppablePage.click();
    }

    public void sortablePage(WebDriver wD) {
        wait.waitToLoad(wD, "#menu-item-151 > a");
        sortablePage.click();
    }
}
