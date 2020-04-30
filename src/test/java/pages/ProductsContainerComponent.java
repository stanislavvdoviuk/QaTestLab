package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsContainerComponent {
    private final String PRODUCT_COMPONENT_CSSSELECTOR=".products";
    protected WebDriver driver;

    private List<ProductComponent> productComponents;

    public ProductsContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements() {
        // init elements
        productComponents = new ArrayList<ProductComponent>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
            productComponents.add(new ProductComponent(current));
        }
    }
    // productComponents
    public List<ProductComponent> getProductComponents() {
        return productComponents;
    }

    public int getProductComponentsCount() {
        return getProductComponents().size();
    }
}
