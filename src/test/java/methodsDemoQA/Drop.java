package methodsDemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

public class Drop {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#draggableview")
    private WebElement dragBox;

    @FindBy(css = "#droppableview")
    private WebElement dropBox;

    public void dragDropBox(WebDriver wD, Actions action) {
        wait.waitToLoad(wD, "#draggableview");
        wait.waitToLoad(wD, "#droppableview");
        action.dragAndDrop(dragBox, dropBox).perform();
    }
}