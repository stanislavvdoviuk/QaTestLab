package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSuccessPage {
    protected WebDriver driver;

    private WebElement totalProducts;
    private WebElement sortBy;

    private void initElements(){
    totalProducts=driver.findElement(By.cssSelector(".total-products"));
    sortBy=driver.findElement(By.cssSelector(".select-title"));
    }
}
