package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class ProductComponent {

    private By nameSelector = By.cssSelector(".product-title");
    private By priceSelector = By.cssSelector(".price");
    private By regularPriceSelector = By.cssSelector(".regular-price");
    private By discountPercentageSelector = By.cssSelector(".discount-percentage");
    private By productThumbnailSelector = By.cssSelector(".product-thumbnail");

    public WebElement getProductName(WebElement product)
    {
        return product.findElement(nameSelector);
    }
    public WebElement getProductPrice(WebElement product) { return product.findElement(priceSelector); }
    public WebElement getProductRegularPrice(WebElement product)
    {
        return product.findElement(regularPriceSelector);
    }
    public WebElement getProductDiscount(WebElement product)
    {
        return product.findElement(discountPercentageSelector);
    }
    public boolean containsProductDiscount(WebElement product)
    {
        try {
            product.findElement(discountPercentageSelector);
        } catch (NoSuchElementException ex) {
            return false;
        }

        return true;
    }
    public WebElement getProductThumbnail(WebElement product)
    {
        return product.findElement(productThumbnailSelector);
    }

    public Double getDoublePrice(WebElement product)
    {
        String[] str=getProductPrice(product).getText().split("\\s+");
        double price = Double.parseDouble(str[0].replace(",", "."));
        return price;
    }
    public String getProductCurrency(WebElement product)
    {
        String[] productCurrency=getProductRegularPrice(product).getText().split("\\s+");
        return productCurrency[1];
    }

    public Double getDoubleRegularPrice(WebElement product)
    {
        String[] str=getProductRegularPrice(product).getText().split("\\s+");
        double regularPrice = Double.parseDouble(str[0].replace(",", "."));
        return regularPrice;
    }

    public Double getDoubleDiscount(WebElement product)
    {
        String productDiscountString = getProductDiscount(product).getText().replace("%", "").replace("-","");
        double discount = Double.parseDouble(productDiscountString);
        return discount;
    }
}
