package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {
    protected WebDriver driver;
    private ProductsContainerComponent productsContainerComponent;

    public HomePage(WebDriver driver) {   super(driver);
        this.driver=driver;
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
