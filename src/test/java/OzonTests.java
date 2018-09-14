import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPages;

import java.io.File;

public class OzonTests {

    WebDriver webDriver;
    AllPages website;
    WebDriverWait wait;

    @Before
    public void setUp() {

        File file = new File("D:\\\\Android\\\\FF_webdriver\\\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        website = new AllPages(webDriver);
        webDriver.get("https://www.ozon.ru/");
        webDriver.manage().window().maximize();
        website.mainPage().clickToBookCategory();
        wait = new WebDriverWait(webDriver, 50, 600);
        website.mainPage().enterBookName("Automation test");
        website.mainPage().clickStartSearch();

    }

    @Test

    public void testURL() {
        while (webDriver.getTitle().equals("Книги – купить книгу в интернет-магазине OZON.ru с доставкой. Выбирайте новинки и бестселлеры по лучшим ценам!")) {
            System.out.println(webDriver.getCurrentUrl());
            wait = new WebDriverWait(webDriver, 50, 600);
        }
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertTrue(webDriver.getCurrentUrl().contains("Automation+test"));
    }

    @Test
    public void testOpenLink() {
        website.searchResultPage().waitForSearchResult();
        website.searchResultPage().firstItemClick();
        webDriver.navigate().back();
    }

    @Test
    public void getTitleOfBook() {
        website.searchResultPage().waitForSearchResult();
        website.searchResultPage().firstItemClick();
        website.bookInfoPage().waitForItemInfo();
        website.bookInfoPage().checkTitleOfItem("Building a GUI Test Automation");
        website.bookInfoPage().checkItemStatus();

    }


//    @Test
//    public void testBookSearch () {
//
//        website.searchResultPage().checkbookSearch();
//    }


//    @Test
//    public void testBookSearch() {
//        website.searchResultPage().waitForSearchResult();
//        website.searchResultPage().openItemFromSearch("Automation");
//        System.out.println(webDriver.getTitle());
//
//    }


//    @Test
//    public void testOpenItemInfoFromSearch()  {
//
//        wait = new WebDriverWait(webDriver, 50, 30000);
//        String itemTitle = website.searchResultPage().getItemTitle();
//        System.out.println(itemTitle);
//        website.searchResultPage().openItemFromSearch("Test Automation");
//        System.out.println(webDriver.getTitle());
//        website.bookInfoPage().waitForItemInfo();
//        website.bookInfoPage().checkTitleOfItem("Test Automation");
//    }

//    @After
//
//    public void tearDown() {
//        if (webDriver != null) {
//            webDriver.quit();
//        }
//
//    }

}
