import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestDemositeLogin {

    private WebDriver webdriver;

    public void pause() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void before() {
        webdriver = new ChromeDriver();
    }

    @After
    public void a() {
        webdriver.quit();
    }

    @Test
    public void testLogin() {
        webdriver.manage().window().maximize();    //maximise Chrome
        webdriver.navigate().to("http://thedemosite.co.uk/");   //go to site

        pause();

        webdriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click(); //go to Add User page

        pause();

        webdriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > " +
                "table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys("amacleod"); //create username
        webdriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > " +
                "table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys("Pa$$w0rd"); //create password
        webdriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click(); //save user

        webdriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a")).click(); //go to Login page

        pause();

        webdriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > " +
                "tr:nth-child(1) > td:nth-child(2) > p > input")).sendKeys("amacleod"); //enter username
        webdriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > " +
                "tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys("Pa$$w0rd"); //enter password

        webdriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click(); //try login

        assertEquals("Login was unsuccessful", "**Successful Login**", webdriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
    }


}
