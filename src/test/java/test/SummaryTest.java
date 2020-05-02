package test;

import data.Currency;
import data.CurrencySymbol;
import data.SortBy;
import helper.NumberHelper;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class SummaryTest extends LocalTestRunner {

    public static final Logger logger = LoggerFactory.getLogger(SummaryTest.class);

    @Test(description = "Check if all product currency is the same as in dropdown currency.",priority = 1)
    public void checkProductCurrency() throws InterruptedException {
        logger.info("Checking products currency.");
        TopPart topPart = new TopPart(getDriver());
        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(getDriver());
        String actual=topPart.getCurrentCurrencySymbol();
        List<WebElement> productElements = productsContainerComponent.getProductElements();
        ProductComponent productComponent = new ProductComponent();
        logger.info("Choosen currancy"+actual);

        for (WebElement el: productElements) {
            Assert.assertTrue(productComponent.getProductPrice(el).getText().contains(actual));
        }

        logger.info("All products have the same currency as choosen.");
    }
    @Test(description = "Check if search field work correctly.",priority = 2)
    public void checkSearchResult() throws InterruptedException {
        TopPart topPart = new TopPart(getDriver());
        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(getDriver());
        topPart.selectCurrency(Currency.US_DOLLAR.toString());
        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct("dress");

        List<WebElement> productElements = productsContainerComponent.getProductElements();
        SearchSuccessPage totalProducts = new SearchSuccessPage(getDriver());
        String total=totalProducts.getTotalProductNumber();
        logger.info("Checking if search result contain "+totalProducts.getTotalProductNumber()+" products.");

        Assert.assertEquals(Integer.parseInt(total),productElements.size());

        logger.info("Searching result contain the same number of product as in TotalProductField.");
    }
    @Test(description = "Check if all products is shown in US_DOLLAR",priority = 3)
    public void checkCurrencyUS() throws InterruptedException {
        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(getDriver());
        List<WebElement> productElements = productsContainerComponent.getProductElements();
        ProductComponent productComponent = new ProductComponent();
        logger.info("Checking if all products currence is "+Currency.US_DOLLAR.toString());

        for (WebElement el: productElements) {
            Assert.assertTrue(productComponent.getProductPrice(el).getText().contains(CurrencySymbol.US_DOLLAR.toString()));
        }

        logger.info("All products have currency "+Currency.US_DOLLAR.toString());
    }
    @Test(description = "Check if all products is sorted by price",priority = 4)
    public void checkSortByMenu() throws InterruptedException {
        SearchSuccessPage searchSuccessPage = new SearchSuccessPage(getDriver());
        searchSuccessPage
                .selectSortingType(SortBy.PRICE_HIGH_LOW.toString());
        Thread.sleep(2000);
        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(getDriver());
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
        logger.info("Checking if all products are sorted.");
        for (int i = 0; i < productPrices.size() - 1; i++) {
            if(productPrices.get(i) < productPrices.get(i + 1)){
                Assert.fail("Prices not sorted");
            }
        }
        logger.info("Products are successfully sorted.");
        Assert.assertTrue(true);
    }
    @Test(description = "Check if the price before and after the discounts is the same as the specified discount size.",priority = 5)
    public void checkDiscount() throws InterruptedException {
        ProductsContainerComponent productsContainerComponent = new ProductsContainerComponent(getDriver());
        List<WebElement> productElements = productsContainerComponent.getProductElements();
        ProductComponent productComponent = new ProductComponent();
        logger.info("Checking if the product discount is calculated correct.");
        for (WebElement element: productElements) {
            if (productComponent.containsProductDiscount(element)) {
                double price = productComponent.getDoublePrice(element);
                double regularPrice = productComponent.getDoubleRegularPrice(element);
                double discount  = productComponent.getDoubleDiscount(element);
                double expectedPrice = NumberHelper.round(regularPrice - (regularPrice / 100.0 * discount), 2);

                Assert.assertEquals(price, expectedPrice);
            }
        }
        logger.info("All products with discount is calculated correct.");
    }
}
