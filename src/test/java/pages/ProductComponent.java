package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComponent {
    private WebElement productLayout;

    private WebElement name;
    private WebElement price;
    private WebElement regularPrice;
    private WebElement discountPercentage;
    private WebElement productThumbnail;

    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        initElements();
    }
    private void initElements() {
        // init elements
        name=productLayout.findElement(By.cssSelector(".product-title"));
        price=productLayout.findElement(By.cssSelector(".price"));
        regularPrice=productLayout.findElement(By.cssSelector(".regular-price"));
        discountPercentage=productLayout.findElement(By.cssSelector(".discount-percentage"));
        productThumbnail=productLayout.findElement(By.cssSelector(".product-thumbnail"));
    }
    // product
    public WebElement getProductLayout() {
        return productLayout;
    }

    // name
    public WebElement getName() {
        return name;
    }

    public String getNameText() {
        return getName().getText();
    }

    public void clickName() {
        getName().click();
    }
    // price
    public WebElement getPrice() {
        return price;
    }

    public String getPriceText() {
        return getPrice().getText();
    }

    // regular price
    public WebElement getRegularPrice() {
        return regularPrice;
    }

    public String getRegularPriceText() {
        return getRegularPrice().getText();
    }
    // price
    public WebElement getDiscountPercentage() {
        return discountPercentage;
    }

    public String getDiscountPercentageText() {
        return getDiscountPercentage().getText();
    }
}
