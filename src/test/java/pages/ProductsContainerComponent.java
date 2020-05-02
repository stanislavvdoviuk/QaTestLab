package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsContainerComponent {
    private final String PRODUCT_COMPONENT_CSSSELECTOR=".products article";
    protected WebDriver driver;

    private List<ProductComponent> productComponents;

    public ProductsContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    // productComponents
    public List<WebElement> getProductElements() {
        return  driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR));
    }
}
