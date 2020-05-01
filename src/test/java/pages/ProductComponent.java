package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductComponent {
//    private WebElement productLayout;
    public String Price;

    private By nameSelector = By.cssSelector(".product-title");
    private By priceSelector = By.cssSelector(".price");
    private By regularPriceSelector = By.cssSelector(".regular-price");
    private By discountPercentageSelector = By.cssSelector(".discount-percentage");
    private By productThumbnailSelector = By.cssSelector(".product-thumbnail");

    public WebElement getProductName(WebElement product)
    {
        return product.findElement(nameSelector);
    }

    public WebElement getProductPrice(WebElement product)
    {
        return product.findElement(priceSelector);
    }
    public WebElement getProductRegularPrice(WebElement product)
    {
        return product.findElement(regularPriceSelector);
    }
    public WebElement getProductDiscount(WebElement product)
    {
        return product.findElement(discountPercentageSelector);
    }
    public WebElement getProductThumbnail(WebElement product)
    {
        return product.findElement(productThumbnailSelector);
    }

//    public Double getDoublePrice()
//    {
//        String[] str=getPriceText().split("\\s+");
//        double price = Double.parseDouble(str[0]);
//        return price;
//    }
    public String getProductCurrency(WebElement product)
    {
        String[] productCurrency=getProductRegularPrice(product).getText().split("\\s+");
        return productCurrency[1];
    }
//
//    // regular price
//    public WebElement getRegularPrice() {
//        return productLayout.findElement(regularPriceSelector);
//    }
//
//    public String getRegularPriceText() {
//        return getRegularPrice().getText();
//    }
//
//    public Double getDoubleRegularPrice()
//    {
//        String[] str=getRegularPriceText().split("\\s+");
//        double regularPrice = Double.parseDouble(str[0]);
//        return regularPrice;
//    }
//
//    // discount
//    public WebElement getDiscountPercentage() {
//        return productLayout.findElement(discountPercentageSelector);
//    }
//
//    public String getDiscountPercentageText() {
//        return getDiscountPercentage().getText();
//    }

//    public Double getDoubleDiscount()
//    {
////        Pattern pattern = Pattern.compile("(\\d+)%");
////        Matcher matcher = pattern.matcher(getDiscountPercentage().getText());
////        String g1 = matcher.group();
////
////        Pattern pattern = Pattern.compile("(\\d+)%");
////        Matcher matcher = pattern.matcher("123%");
////        matcher.find();
////        System.out.println(matcher.group(1));
//////        String[] str=getDiscountPercentageText().split("\\d+");
//
//        return discount;
//    }
}
