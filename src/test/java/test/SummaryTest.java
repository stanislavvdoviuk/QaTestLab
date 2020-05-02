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

        List<WebElement> productElements = productsContainerComponent.getProductElements();
        ProductComponent productComponent = new ProductComponent();
        Thread.sleep(5000);
        //String actual=topPart.getCurrentCurrencySymbol();
//        for (WebElement el: productElements) {
//            softAssert.assertTrue(productComponent.getProductPrice(el).getText().contains(actual));
//        }
        topPart.selectCurrency(Currency.US_DOLLAR.toString());
        topPart.searchProduct("dress");
        SearchSuccessPage searchSuccessPage=new SearchSuccessPage(getDriver());

        softAssert.assertEquals(Integer.parseInt(searchSuccessPage.getTotalProductNumber()),productElements.size());

        for (WebElement element: productElements) {
            softAssert.assertTrue(productComponent.getProductPrice(element).getText().contains(Currency.US_DOLLAR.toString()));
        }
        searchSuccessPage.selectSortingType(SortBy.NAME_ZA.toString());
    }
}
