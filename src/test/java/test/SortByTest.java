package test;

import data.Currency;
import data.Languages;
import data.SortBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class SortByTest extends LocalTestRunner {
    @Test
    public void checkSortByMenu() throws InterruptedException {
        TopPart topPart=new TopPart(getDriver());
        Thread.sleep(2000);
        SearchSuccessPage searchSuccessPage = new SearchSuccessPage(getDriver())
                .searchProduct("dress")
                .selectSortingType(SortBy.PRICE_HIGH_LOW.toString());
        Thread.sleep(2000);
        ProductsContainerComponent productsContainerComponent=new ProductsContainerComponent(getDriver());
        ProductComponent productComponent = new ProductComponent();
        List<WebElement> productElements = productsContainerComponent.getProductElements();
        List<Double> productPrices = new ArrayList<Double>();
        for (WebElement element: productElements) {
            if (productComponent.containsProductDiscount(element)) {
                productPrices.add(productComponent.getDoubleRegularPrice(element));
            } else {
                productPrices.add(productComponent.getDoublePrice(element));
            }
        }

        for (int i = 0; i < productPrices.size() - 1; i++) {
            if(productPrices.get(i) < productPrices.get(i + 1)){
                Assert.fail("Prices not sorted");
            }
        }

        Assert.assertTrue(true);
    }
}
