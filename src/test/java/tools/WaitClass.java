package tools;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class WaitClass {

    public void waitToLoad(WebDriver wD, final String css) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(wD)
                .withTimeout(3, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement w = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector(css));
            }
        });
    }
}
