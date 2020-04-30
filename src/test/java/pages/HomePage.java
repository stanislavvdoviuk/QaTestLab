package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {

    private ProductsContainerComponent productsContainerComponent;

    public HomePage(WebDriver driver)
    {   super(driver);
        initElements();}
    private void initElements()
    {
        productsContainerComponent=new ProductsContainerComponent(driver);
    }
    // productComponentsContainer
    public ProductsContainerComponent getProductComponentsContainer() {
        return productsContainerComponent;
    }
}
