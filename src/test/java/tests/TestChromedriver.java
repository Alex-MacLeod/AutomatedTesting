package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class TestChromedriver {

    private WebDriver webdriver;

    @Before
    public void before() {
        webdriver = new ChromeDriver();
    }

    @Test
    public void testText() {
        webdriver.manage().window().maximize();
        webdriver.navigate().to("http://www.qa.com");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a/span")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.findElement(By.xpath("//*[@id=\"course-lists\"]/div[2]/article[1]/div/ul/li[1]/a")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("Couldn't find text", "At a glance", webdriver.findElement(By.xpath("//*[@id=\"at-a-glance\"]/div[1]/header/h1")).getText());
    }

    @After
    public void a() {
        webdriver.quit();
    }
}
