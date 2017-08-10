package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import methodsDemoQA.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import tools.ScreenShot;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestDemoQA {

    private static WebDriver cD;
    private Actions mouse;

    private Navigate navi;
    private FillForm fill;
    private Drag drag;
    private Drop drop;
    private Sort sort;

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

        cD = new ChromeDriver();
        cD.manage().window().maximize();    //maximise Chrome
    }

    @Before
    public void before() {

        test = report.createTest("DemoQA Success");

        ss = new ScreenShot();
        //reader = new SpreadSheetReader();

        mouse = new Actions(cD);

        navi = PageFactory.initElements(cD, methodsDemoQA.Navigate.class);
        fill = PageFactory.initElements(cD, FillForm.class);
        drag = PageFactory.initElements(cD, Drag.class);
        drop = PageFactory.initElements(cD, Drop.class);
        sort = PageFactory.initElements(cD, Sort.class);
    }

    @After
    public void after() {

    }

    @AfterClass
    public static void afterClass() {
        cD.quit();
        report.flush();
    }

    @Ignore
    public void testRegistration() {

        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.registrationPage(cD); //go to Registration page
        test.log(Status.INFO, "Navigated to Registration page");

        fill.enterName(cD, "Carlos", "Danger"); //entered name
        test.log(Status.INFO, "Entered name");

        cD.findElement(By.cssSelector("#pie_register > li:nth-child(2) > div > div > input:nth-child(2)")).click();
        cD.findElement(By.cssSelector("#pie_register > li:nth-child(3) > div > div > input:nth-child(4)")).click();
        test.log(Status.INFO, "Inputted Marital Status and Hobby");

        fill.selectDetails(cD, "United States", "7", "4", "1976");
        test.log(Status.INFO, "Added personal details");

        fill.enterContactDetails("1234567891", "name@email.com");
        test.log(Status.INFO, "Added contact details");
        //TODO: can change email

        fill.newUser("cdanger", "carlos100%s3xy");
        test.log(Status.INFO, "Added new user");

        //fill.addProfilePic(mouse,"profile.jpg");
        //test.log(Status.INFO, "Added profile picture");
        //TODO: get addProfilePic to successfully choose picture

        cD.findElement(By.cssSelector("#pie_register > li:nth-child(14) > div > input[type=\"submit\"]")).click();
        test.log(Status.INFO, "Submitted form");

        ss.take(cD, "DemoQARegistrationScreenshot");
        test.log(Status.INFO, "Screenshot taken");

        String expectedText = "Thank you for your registration";
        String actualText = cD.findElement(By.cssSelector("#post-49 > div > p")).getText();
        assertEquals("Form successfully submitted", expectedText, actualText);

        if (expectedText.equals(actualText)) {
            test.log(Status.PASS, "Form successfully submitted");
        } else {
            test.log(Status.FAIL, "Error submitting form");
        }
    }

    @Ignore
    public void testDraggable() {
        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.draggablePage(cD); //go to Draggable page
        test.log(Status.INFO, "Navigated to Draggable page");

        drag.dragBox(cD, mouse, 1000, 600);
        test.log(Status.INFO, "Dragged box");

        cD.findElement(By.cssSelector("#ui-id-4")).click(); //go to Events tab

        drag.dragUntil(cD, mouse);
        test.log(Status.INFO, "Drag box between 2 points 500 times");

        ss.take(cD, "DemoQADraggableScreenshot");
        test.log(Status.INFO, "Screenshot taken");

        boolean bool = Integer.parseInt(cD.findElement(By.cssSelector("#event-drag > span.count")).getText())<200;
        assertFalse("Drag failed", bool);

        if (!bool) {
            test.log(Status.PASS, "Drag successful");
        } else {
            test.log(Status.FAIL, "Drag failed");
        }
    }

    @Ignore
    public void testDroppable() {
        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.droppablePage(cD); //go to Droppable page
        test.log(Status.INFO, "Navigated to Droppable page");

        drop.dragDropBox(cD, mouse);
        test.log(Status.INFO, "Dragged box and dropped into drop box");

        ss.take(cD, "DemoQADroppableScreenshot");
        test.log(Status.INFO, "Screenshot taken");

        WebElement droppedBox = cD.findElement(By.cssSelector("#droppableview > p"));
        assertEquals("Drop failed","Dropped!", droppedBox.getText());

        if ("Dropped!".equals(droppedBox.getText())) {
            test.log(Status.PASS, "Box dropped successfully");
        } else {
            test.log(Status.FAIL, "Drop failed");
        }
    }

    @Test
    public void testSortable() {
        navi.homePage(cD);   //navigate to site
        test.log(Status.INFO, "Navigated to site");

        navi.sortablePage(cD); //go to Sortable page
        test.log(Status.INFO, "Navigated to Sortable page");

        sort.reverseSortListItems(cD, mouse);
        test.log(Status.INFO, "Sort items into reverse order");

        cD.findElement(By.cssSelector("#ui-id-3")).click(); //go to Display as Grid tab

        sort.reverseSortGridItems(cD, mouse);
        test.log(Status.INFO, "Sort items into reverse order");

        ss.take(cD, "DemoQASortScreenshot");
        test.log(Status.INFO, "Screenshot taken");

        WebElement topItem = cD.findElement(By.cssSelector("#sortable > li:nth-child(1)"));
        assertEquals("Sort failed","Item 7", topItem.getText());

        if ("Item 7".equals(topItem.getText())) {
            test.log(Status.PASS, "Items resorted");
        } else {
            test.log(Status.FAIL, "Sort failed");
        }
    }
}
