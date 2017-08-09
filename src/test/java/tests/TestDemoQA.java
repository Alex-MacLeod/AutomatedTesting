package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import methodsDemoQA.EnterName;
import methodsDemoQA.Navigate;
import methodsDemoQA.SelectDetails;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tools.ScreenShot;

public class TestDemoQA {

    private static WebDriver cD;
    private Actions mouse;

    private Navigate navi;
    private EnterName name;
    private SelectDetails details;

    private ScreenShot ss;
    //private SpreadSheetReader reader;

    private static ExtentReports report;
    private ExtentTest test;
    private static String reportFilePath = "DemoQAReport.html";

    @BeforeClass
    public static void beforeClass(){
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("DemoQA Report");
        extentHtmlReporter.config().setDocumentTitle("DemoQAReport");
        report.attachReporter(extentHtmlReporter);
    }

    @Before
    public void before() {

        test = report.createTest("DemoQA Success");

        ss = new ScreenShot();
        //reader = new SpreadSheetReader();

        cD = new ChromeDriver();
        mouse = new Actions(cD);

        navi = PageFactory.initElements(cD, methodsDemoQA.Navigate.class);
        name = PageFactory.initElements(cD, EnterName.class);
        details = PageFactory.initElements(cD, SelectDetails.class);

        cD.manage().window().maximize();    //maximise Chrome
    }

    @After
    public void after() {
        // if (testCount<11) {
        //     testCount++;
        // }
        // cD.quit();
    }

    @AfterClass
    public static void afterClass() {
        cD.quit();
        report.flush();
    }

    @Test
    public void testRegistration() {

        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.registrationPage(cD); //go to Registration page
        test.log(Status.INFO, "Navigated to Registration page");

        name.enterName(cD, "Carlos", "Danger"); //entered name
        test.log(Status.INFO, "Entered name");

        cD.findElement(By.cssSelector("#pie_register > li:nth-child(2) > div > div > input:nth-child(2)")).click();
        cD.findElement(By.cssSelector("#pie_register > li:nth-child(3) > div > div > input:nth-child(4)")).click();

        details.selectDetails(cD, "United States", "7", "4", "1976");

    }
}
