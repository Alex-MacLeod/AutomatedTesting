package tests;

import tools.SpreadSheetReader;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import methodsDemosite.CreateUser;
import methodsDemosite.Login;
import methodsDemosite.Navigate;
import org.junit.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import static junit.framework.TestCase.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import tools.ScreenShot;

import java.util.List;

public class TestDemositeLogin {

    private static WebDriver cD;

    private Navigate navi;
    private CreateUser user;
    private Login login;

    private ScreenShot sc;
    private SpreadSheetReader reader;

    private static ExtentReports report;
    private ExtentTest test;

    @BeforeClass
    public static void beforeClass(){
        report = new ExtentReports();
        String reportFilePath = "DemositeLoginReport.html";
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Demosite Login Report");
        extentHtmlReporter.config().setDocumentTitle("DemositeLoginReport");
        report.attachReporter(extentHtmlReporter);
    }

    @Before
    public void before() {

        test = report.createTest("loginSuccess");

        sc = new ScreenShot();
        reader = new SpreadSheetReader();

        cD = new ChromeDriver();
        navi = PageFactory.initElements(cD, Navigate.class);
        login = PageFactory.initElements(cD, Login.class);
        user = PageFactory.initElements(cD,CreateUser.class);

        cD.manage().window().maximize();    //maximise Chrome
    }

    @AfterClass
    public static void afterClass() {
        cD.quit();
        report.flush();
    }

    @Test
    public void testLogin1() {
        int randomRow = (int) Math.ceil(2 + Math.random()*9);
        List<String> inputDataRow = reader.readRow(randomRow, "inputData");
        String username = inputDataRow.get(2);
        String password = inputDataRow.get(3);

        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.addUserPage(cD); //go to Add User page
        test.log(Status.INFO, "Navigated to Add User page");

        user.createUser(cD, username, password);    //create user
        test.log(Status.INFO, "Created user");

        navi.loginPage(cD); //go to Login page
        test.log(Status.INFO, "Navigated to Login page");

        login.login(cD, username, password);    //log in
        test.log(Status.INFO, "Logged in as user");

        sc.take(cD, "DemositeLoginScreenshot");
        test.log(Status.INFO, "Screenshot taken");

        List<String> outputDataRow = reader.readRow(2, "outputData");
        String expectedText = outputDataRow.get(2);

        String actualText = cD.findElement(By.cssSelector("blockquote > font > center > b")).getText();
        assertEquals("Login was unsuccessful", expectedText, actualText);   //check for login successful message

        if (expectedText.equals(actualText)) {
            test.log(Status.PASS, "Successful Login with user: " + username);
        } else {
            test.log(Status.FAIL, "Login was unsuccessful");
        }
    }
}
