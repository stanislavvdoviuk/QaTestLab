package test;

import data.Currency;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class SearchTest extends LocalTestRunner{
    @Test(description = "Check if search field work correctly")
    public void checkSearchResult() throws InterruptedException {
        TopPart topPart=new TopPart(getDriver());
        ProductsContainerComponent productsContainerComponent=new ProductsContainerComponent(getDriver());
        Thread.sleep(5000);
        topPart.selectCurrency(Currency.US_DOLLAR.toString());
        HomePage homePage=new HomePage(getDriver());
        homePage.searchProduct("dress");

        List<WebElement> productElements = productsContainerComponent.getProductElements();

        SearchSuccessPage totalProducts=new SearchSuccessPage(getDriver());
        String total=totalProducts.getTotalProductNumber();

        Assert.assertEquals(Integer.parseInt(total),productElements.size());
    }
}
