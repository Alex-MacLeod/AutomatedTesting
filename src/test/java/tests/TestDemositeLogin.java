package tests;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import methods.CreateUser;
import methods.Login;
import methods.Navigate;
import org.junit.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import static junit.framework.TestCase.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import report.ScreenShot;

public class TestDemositeLogin {

    private WebDriver cD;
    private Navigate navi;
    private CreateUser user;
    private Login login;

    private ScreenShot sc;

    private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "report.html";

    @BeforeClass
    public static void init(){

    }

    @Before
    public void before() {
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Demosite Login Report");
        extentHtmlReporter.config().setDocumentTitle("DemositeLoginReport");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("loginSuccess");

        sc = new ScreenShot();

        cD = new ChromeDriver();
        navi = PageFactory.initElements(cD,Navigate.class);
        login = PageFactory.initElements(cD, Login.class);
        user = PageFactory.initElements(cD,CreateUser.class);

        cD.manage().window().maximize();    //maximise Chrome
    }

    @After
    public void a() {
        cD.quit();
        report.flush();
    }


    @Test
    public void testLogin() {
        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.addUserPage(cD); //go to Add User page
        test.log(Status.INFO, "Navigated to Add User page");

        user.createUser(cD, "amacleod", "Pa$$w0rd");    //create user
        test.log(Status.INFO, "Created user");

        navi.loginPage(cD); //go to Login page
        test.log(Status.INFO, "Navigated to Login page");

        login.login(cD, "amacleod", "Pa$$w0rd");    //log in
        test.log(Status.INFO, "Logged in as user");

        sc.take(cD, "screenshot");
        test.log(Status.INFO, "Screenshot taken");

        String text = cD.findElement(By.cssSelector("blockquote > font > center > b")).getText();
        assertEquals("Login was unsuccessful", "**Successful Login**", text);   //check for login successful message

        if ("**Successful Login**".equals(text)) {
            test.log(Status.PASS, "Successful Login");
        } else {
            test.log(Status.FAIL, "Login was unsuccessful");
        }
    }
}
