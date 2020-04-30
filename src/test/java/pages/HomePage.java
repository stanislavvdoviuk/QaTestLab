package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {

    private ProductsContainerComponent productsContainerComponent;

    private void initElements()
    {
        productsContainerComponent=new ProductsContainerComponent(driver);
    }
    // productComponentsContainer
    public ProductsContainerComponent getProductComponentsContainer() {
        return productsContainerComponent;
    }
}
