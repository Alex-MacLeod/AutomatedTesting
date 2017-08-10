package methodsDemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

public class Drag {

    private WaitClass wait = new WaitClass();

    @FindBy (css = "#draggable")
    private WebElement draggable;

    @FindBy (css = "#dragevent > p")
    private WebElement dragUntil;

    public void dragBox(WebDriver wD, Actions action, int x, int y) {
        wait.waitToLoad(wD, "#draggable");
        action.dragAndDropBy(draggable, x, y).perform();
    }

    public void dragUntil(WebDriver wD, Actions action) {
        wait.waitToLoad(wD, "#dragevent > p");
        action.dragAndDropBy(dragUntil, 200, 100).perform();    //centre box
        do {
            int randomX = (int) Math.ceil(-100 + Math.random()*200);
            int randomY = (int) Math.ceil(-100 + Math.random()*200);
            action.dragAndDropBy(dragUntil, randomX, randomY).perform();    //moves to a random position
            action.dragAndDropBy(dragUntil, -randomX, -randomY).perform();  //moves back
        } while (Integer.parseInt(wD.findElement(By.cssSelector("#event-drag > span.count")).getText())<200);
        //moves 200 times
    }
}
