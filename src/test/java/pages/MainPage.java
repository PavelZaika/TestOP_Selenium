package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "/html/body/div[2]/form/div/div[3]/div[2]/a[2]")
    WebElement linkToBook;

    @FindBy(id = "SearchText")
    WebElement searchField;

//    @FindBy(css = "#StartSearch")
//    WebElement startSearch;

    public MainPage(WebDriver driver) {

        webDriver = driver;
        wait = new WebDriverWait(webDriver, 40, 500);
        PageFactory.initElements(webDriver, this);
    }


    public void clickToBookCategory() {
        linkToBook.click();
    }

    public void enterBookName(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickStartSearch() {
        searchField.sendKeys(Keys.ENTER);

    }

}
