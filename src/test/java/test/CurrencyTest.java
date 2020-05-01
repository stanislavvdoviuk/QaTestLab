package test;

import data.Currency;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductComponent;
import pages.ProductsContainerComponent;
import pages.TopPart;

import java.util.List;

public class CurrencyTest extends LocalTestRunner{
 @Test(description = "Check if product currency is correct")
 public void checkProductCurrency() throws InterruptedException {
     TopPart topPart=new TopPart(getDriver());
     ProductsContainerComponent productsContainerComponent=new ProductsContainerComponent(getDriver());
     Thread.sleep(2000);
     //topPart.selectCurrency(Currency.US_DOLLAR.toString());
     String actual=topPart.getCurrentCurrencySymbol();

     List<WebElement> productElements = productsContainerComponent.getProductElements();
     ProductComponent productComponent = new ProductComponent();

     for (WebElement el: productElements) {
         Assert.assertTrue(productComponent.getProductPrice(el).getText().contains(actual));
     }

 }
}
