package methodsDemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import tools.WaitClass;

import java.util.concurrent.TimeUnit;

public class Sort {

    private WaitClass wait = new WaitClass();

    @FindBy(css = "#sortable > li:nth-child(1)")
    private WebElement listItem;

    @FindBy(css = "#sortable_grid > li:nth-child(1)")
    private WebElement gridItem;

    private void pause() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dragListItem(Actions action, int y) {
        action.dragAndDropBy(listItem, 0, y).perform();
    }

    private void dragGridItem(Actions action, int x, int y) {
        action.dragAndDropBy(gridItem, x, y).perform();
    }

    public void reverseSortListItems(WebDriver wD, Actions action) {
        wait.waitToLoad(wD, "#sortable > li:nth-child(1)");
        int y=200;
        while (y>0) {
            dragListItem(action, y);
            y=y-33;
            pause();
        }

    }

    public void reverseSortGridItems(WebDriver wD, Actions action) {
        wait.waitToLoad(wD, "#sortable_grid > li:nth-child(1)");
        int x=300;
        int y=200;
        while (y>0) {
            dragListItem(action, y);
            y=y-66;
            while (x>0) {
                dragListItem(action, y);
                x=x-75;
            }
            pause();
        }
    }
}
