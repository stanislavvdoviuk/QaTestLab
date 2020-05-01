package pages;
import data.Currency;
import data.Languages;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TopPart {
    protected WebDriver driver;

    private By currentCurrencySelector = By.cssSelector(".currency-selector span.expand-more");

    private By dropdownCurrencySelector = By.cssSelector(".currency-selector .dropdown-menu");

    private By searchFieldSelector = By.cssSelector(".ui-autocomplete-input");
    private By searchButtonSelector = By.cssSelector("#search_widget button");
    private By logoSelector = By.cssSelector("#_desktop_logo");
    private By currentLanguageSelector = By.cssSelector(".language-selector");

    private By dropdownLanguageSelector = By.cssSelector(".language-selector .dropdown-menu");

    private By shoppingCartSelector = By.cssSelector("#_desktop_cart");
    private By contactUsSelector = By.cssSelector("#contact-link");
    private By logInSelector = By.cssSelector(".user-info");
    private By categorieSelector = By.cssSelector(".category");

    public TopPart(WebDriver driver)  {
        this.driver=driver;
    }

    // currency
    public WebElement getCurrentCurrency() {
        return driver.findElement(currentCurrencySelector);
    }

    public void clickCurrentCurrency() {
        getCurrentCurrency().click();
    }
    public String getCurrentCurrencySymbol()
    {
//        getCurrentCurrency().getText();
//        return getCurrentCurrency().getText().substring(getCurrentCurrency().getText().length()-1);
        String[] str=getCurrentCurrency().getText().split("\\s+");
        return str[1];
    }

    // language
    public WebElement getCurrentLanguage() {
        return driver.findElement(currentLanguageSelector);
    }

    public void clickLanguage() {
        getCurrentLanguage().click();
    }

    //go to HomePage
    public WebElement getLogo() {
        return driver.findElement(logoSelector);
    }

    public void clickLogo() {
        getLogo().click();
    }

    //contact us
    public WebElement getContactUs() {
        return driver.findElement(contactUsSelector);
    }

    public void clickContactUs() {
        getContactUs().click();
    }

    //go to Shopping Cart
    public WebElement getShoppingCart() {
        return driver.findElement(shoppingCartSelector);
    }

    public void clickShoppingCart() {
        getShoppingCart().click();
    }

    // searchField
    public WebElement getSearchField() {
        return driver.findElement(searchFieldSelector);
    }

    public void clearSearchTopField() {
        getSearchField().clear();
    }

    public void clickSearchTopField() {
        getSearchField().click();
    }

    public void setSearchTopField(String product) {
        getSearchField().click();
        getSearchField().sendKeys(product);
    }

    //searchButton
    public WebElement getSearchButton() {
        return driver.findElement(searchButtonSelector);
    }

    public void clickSearchTopButton()  {
        getSearchButton().click();
    }
    public SearchSuccessPage searchProduct(String product)
    {
        setSearchTopField(product);
        clickSearchTopButton();
        return new SearchSuccessPage(driver);
    }

    public HomePage goToHomePage()  {
        clickLogo();
        return new HomePage(driver);
    }

    //Functional

    //Currency
    private void openCurrencyDropdownComponent() {
        clickCurrentCurrency();
    }

    public TopPart selectCurrency(String curr) throws InterruptedException {
        openCurrencyDropdownComponent();
        Thread.sleep(2000);
        List<WebElement> dropdownCurrencyElements=driver.findElement(dropdownCurrencySelector).findElements(By.tagName("li"));
        for (WebElement li : dropdownCurrencyElements) {
            if (li.getText().equals(curr)) {
                li.click();
            }
        }
        return new TopPart(driver);
    }

    //Language
    private void openLanguageDropdownComponent()
    {
        clickLanguage();
    }
    public TopPart selectLanguage(String languag) throws InterruptedException {
        openLanguageDropdownComponent();
        Thread.sleep(2000);
        List<WebElement> dropdownLanguageElements=driver.findElement(dropdownLanguageSelector).findElements(By.tagName("li"));
        for (WebElement li : dropdownLanguageElements) {
            if (li.getText().equals(languag)) {
                li.click();
            }
        }
        return new TopPart(driver);
    }

}
