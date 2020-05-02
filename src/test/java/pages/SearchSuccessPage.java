package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchSuccessPage extends TopPart{
    protected WebDriver driver;
    private By totalProductSelector = By.cssSelector(".total-products");
    private By sortByMenu = By.cssSelector(".select-title");
    private By sortByDropdown = By.cssSelector("#js-product-list-top > div:nth-child(2) > div > div > div");

    public SearchSuccessPage(WebDriver driver)  {
        super(driver);
        this.driver=driver;
    }

    private WebElement getTotalProducts()
    {
        return driver.findElement(totalProductSelector);
    }

    public String getTotalProductNumber()
    {
        Pattern pattern = Pattern.compile("(\\d+).");
        Matcher matcher = pattern.matcher(getTotalProducts().getText());
        matcher.find();
        return matcher.group(1);

    }
    private WebElement getSortByList(){
        return driver.findElement(By.className("select-title"));
    }

    private void openSortByDropdownComponent() {
        getSortByList().click();
        logger.info("Clicking on SortBy dropdown.");
    }

    public SearchSuccessPage selectSortingType(String sortBy)  {
        openSortByDropdownComponent();
        List<WebElement> dropdownCurrencyElements=driver.findElement(sortByDropdown).findElements(By.tagName("a"));
        for (WebElement a : dropdownCurrencyElements) {
            if (a.getText().equals(sortBy)) {
                a.click();
            }
        }
        logger.info("Clicking on "+sortBy);
        return new SearchSuccessPage(driver);
    }
}
