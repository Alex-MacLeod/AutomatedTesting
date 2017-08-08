import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestDemositeLogin {

    private WebDriver cD;
    private Navigate navi;
    private CreateUser user;
    private Login login;


    @Before
    public void before() {
        cD = new ChromeDriver();
        navi = PageFactory.initElements(cD,Navigate.class);
        login = PageFactory.initElements(cD,Login.class);
        user = PageFactory.initElements(cD,CreateUser.class);

        cD.manage().window().maximize();    //maximise Chrome
    }

    @After
    public void a() {
        cD.quit();
    }

    @Test
    public void testLogin() {
        navi.homePage(cD);   //navigate to site
        navi.addUserPage(cD); //go to Add User page
        user.createUser(cD, "amacleod", "Pa$$w0rd");    //create user
        navi.loginPage(cD); //go to Login page
        login.login(cD, "amacleod", "Pa$$w0rd");    //log in

        String text = cD.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
        assertEquals("Login was unsuccessful", "**Successful Login**", text);   //check for login successful message
    }


}
