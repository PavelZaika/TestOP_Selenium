package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookInfoPage {


    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(className = "bItemName")
    WebElement itemTitle;

    @FindBy (css = "#PageCenter > div:nth-child(2) > div.bDetailPage.mNoBreadcrumbs > div.bDetailHeadBlock > div.bBaseInfoColumn > div.bSaleColumn > div.bSaleBlock > div.eSaleBlock_colorWrap > div.eSaleBlock_centerMessage")
    WebElement itemStatus;

    @FindBy(xpath = "//*[@id=\"PageCenter\"]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div")
    WebElement addItemButton;


    public BookInfoPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 40, 500);
        PageFactory.initElements(webDriver, this);

    }

    public void waitForItemInfo() {
        wait.until(ExpectedConditions.visibilityOf(itemTitle));
    }

    public void checkitemTitles(String title) {

        System.out.println(itemTitle.getText());
        Assert.assertTrue(itemTitle.getText().contains(title));
    }

    public void checkItemStatus() {

        if (itemStatus.getText().equals("Узнать о поступлении")) {
            System.out.println("Back");
            webDriver.navigate().back();

        } else {

            addItemButton.click();

        }
    }
}
