package methodsDemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDetails {

    WebDriver wD;

    public void selectDetails(WebDriver wD, String country, String month, String day, String year) {
        Select selectCountry = new Select(wD.findElement(By.cssSelector("#dropdown_7")));
        Select selectBirthMonth = new Select(wD.findElement(By.cssSelector("#mm_date_8")));
        Select selectBirthDay = new Select(wD.findElement(By.cssSelector("#dd_date_8")));
        Select selectBirthYear = new Select(wD.findElement(By.cssSelector("#yy_date_8")));
        selectCountry.selectByValue(country);
        selectBirthMonth.selectByValue(month);
        selectBirthDay.selectByValue(day);
        selectBirthYear.selectByValue(year);
    }
}
