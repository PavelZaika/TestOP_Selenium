package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SearchResultPage {

    private WebDriver webDriver;
    private WebDriverWait wait;



    @FindBy (className = "eOneTile_ItemName" )
    WebElement firstItem;

//    @FindBy(xpath = "//*[@id=\"bTilesModeShow\"]")
//   List<WebElement> itemLinks;

    public SearchResultPage (WebDriver driver) {
        webDriver= driver;
        wait = new WebDriverWait(webDriver, 40, 500);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForSearchResult() {
        wait.until(ExpectedConditions.titleContains("Результаты поиска"));
    }


    public void firstItemClick () {

        firstItem.click();

    }


//    public void openItemFromSearch (String itemTitle) {
//
//        for (WebElement itemLink: itemLinks) {
//
//            if (itemLink.getAttribute("Title").contains(itemTitle)){
//
//                itemLink.click();
//                break;
//            }
//        }
//    }
//
//    public String getItemTitle() {
//
//        Random random = new Random();
//        int index = random.nextInt(itemLinks.size());
//        String itemTitle = itemLinks.get(index).getAttribute("title");
//        return itemTitle;
//    }

//public void checkbookSearch () {
//
//        Assert.assertTrue(itemLinks.size()!=0);
//}

}
