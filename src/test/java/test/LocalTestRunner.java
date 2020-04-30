package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunner {
    private String url = "http://prestashop-automation.qatestlab.com.ua/ru/";
    private Map<Long, WebDriver> drivers;

    protected WebDriver getDriver() {
        WebDriver currentWebDriver = drivers.get(Thread.currentThread().getId());
        if (currentWebDriver == null) {
            currentWebDriver = new ChromeDriver();
            currentWebDriver.manage().window().maximize();
            currentWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            drivers.put(Thread.currentThread().getId(), currentWebDriver);
        }
        return currentWebDriver;
    }
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        drivers = new HashMap<Long, WebDriver>();
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
                url = entry.getValue();
        }
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        for (Map.Entry<Long, WebDriver> currentWebDriver : drivers.entrySet()) {
            if (currentWebDriver.getValue() != null) {
                currentWebDriver.getValue().quit();
            }
        }
    }
     public HomePage loadApplication(){return new HomePage(getDriver());}
}

