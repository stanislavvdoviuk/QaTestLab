package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;

public class TopPart {
    protected WebDriver driver;

    private WebElement currency;
    private WebElement searchField;
    private WebElement searchButton;
    private WebElement logo;
    private WebElement language;
    private WebElement shoppingCart;
    private WebElement contactUs;
    private WebElement logIn;
    private WebElement categorie;

    public TopPart(WebDriver driver)
    {
        initElement();
    }

    private void initElement(){
        currency=driver.findElement(By.cssSelector(".currency-selector .expand-more"));
        searchField=driver.findElement(By.cssSelector(".ui-autocomplete-input"));
        searchButton=driver.findElement(By.cssSelector("#search_widget button"));
        logo=driver.findElement(By.cssSelector("#_desktop_logo"));
        language=driver.findElement(By.cssSelector(".language-selector-"));
        shoppingCart=driver.findElement(By.cssSelector("#_desktop_cart"));
        contactUs=driver.findElement(By.cssSelector("#contact-link"));
        logIn=driver.findElement(By.cssSelector(".user-info"));
        categorie=driver.findElement(By.cssSelector(".category"));
    }

    // currency
    public WebElement getCurrency()
    { return currency; }
    public void clickCurrency(){getCurrency().click();}

    // language
    public WebElement getLanguage()
    {return language;}
    public void clickLanguage(){getLanguage().click();}

    //go to HomePage
    public WebElement getLogo() {
        return logo;
    }
    public void clickLogo(){getLogo().click();}

    //contact us
    public WebElement getContactUs()
    {return contactUs;}
    public void clickContactUs()
    {getContactUs().click();}

    //go to Shopping Cart
    public WebElement getShoppingCart() {
        return shoppingCart;
    }
    public void clickShoppingCart()
    {shoppingCart.click();}

    // searchField
    public WebElement getSearchField()
    {
        return searchField;
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
        return searchButton;
    }

//    public SearchPage clickSearchTopButton() {
//        getSearchButton().click();
//        //return new SearchPage(driver);
//    }
//    public HomePage goToHomePage()
//    {clickLogo();
//    //return new HomePage(driver)
//    }

    //Functional

    //Currency
    private void openCurrencyDropdownComponent()
    {
        clickCurrency();

    }
}
