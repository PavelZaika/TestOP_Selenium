package pages;

import org.openqa.selenium.WebDriver;


public class AllPages {


  WebDriver webDriver;

    public AllPages(WebDriver driver) {
        webDriver = driver;

    }


    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    public SearchResultPage searchResultPage() {
        return new SearchResultPage(webDriver);
    }

    public BookInfoPage bookInfoPage() {
        return new BookInfoPage(webDriver);
    }


}
