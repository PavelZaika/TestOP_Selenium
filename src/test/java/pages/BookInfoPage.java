package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookInfoPage {


    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy (className = "bItemName")
    WebElement itemTitle;


    public BookInfoPage (WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 40, 500);
        PageFactory.initElements(webDriver, this);

    }

    public void waitForItemInfo () {
        wait.until(ExpectedConditions.visibilityOf(itemTitle));
    }

    public void checkitemTitles (String title) {

        System.out.println(itemTitle.getText());
        Assert.assertTrue(itemTitle.getText().contains(title));
    }
}
