package test;

import data.Currency;
import data.Languages;
import data.SortBy;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchSuccessPage;
import pages.TopPart;

public class SortByTest extends LocalTestRunner {
    @Test
    public void checkSortByMenu() throws InterruptedException {
        TopPart topPart=new TopPart(getDriver());
        Thread.sleep(2000);
        topPart.selectLanguage(Languages.UKRAINIAN.toString());
        Thread.sleep(1000);
        SearchSuccessPage searchSuccessPage = new SearchSuccessPage(getDriver())
                .searchProduct("dress")
                .selectSortingType(SortBy.NAME_ZA.toString());

        //  Assert.assertEquals(productsContainerComponent.getProductComponentsCount(),7);
    }
}
