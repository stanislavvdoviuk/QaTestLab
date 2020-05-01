package test;

import data.Currency;
import data.SortBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductComponent;
import pages.ProductsContainerComponent;
import pages.SearchSuccessPage;
import pages.TopPart;

import java.util.List;

public class SummaryTest extends LocalTestRunner {
    @Test
    public void shopTest() throws InterruptedException {
        TopPart topPart=new TopPart(getDriver());
        ProductsContainerComponent productsContainerComponent=new ProductsContainerComponent(getDriver());
        Thread.sleep(2000);
        String actual=topPart.getCurrentCurrencySymbol();

        List<WebElement> productElements = productsContainerComponent.getProductElements();
        ProductComponent productComponent = new ProductComponent();
        Thread.sleep(2000);
        for (WebElement el: productElements) {
            softAssert.assertTrue(productComponent.getProductPrice(el).getText().contains(actual));
        }
        topPart.selectCurrency(Currency.US_DOLLAR.toString());
        topPart.searchProduct("dress");
        SearchSuccessPage searchSuccessPage=new SearchSuccessPage(getDriver());

        softAssert.assertEquals(Integer.parseInt(searchSuccessPage.getTotalProductNumber()),productElements.size());

        for (WebElement el: productElements) {
            softAssert.assertTrue(productComponent.getProductPrice(el).getText().contains(Currency.US_DOLLAR.toString()));
        }
        searchSuccessPage.selectSortingType(SortBy.NAME_ZA.toString());
    }
}
