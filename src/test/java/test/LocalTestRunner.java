package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunner  {
    private String url = "http://prestashop-automation.qatestlab.com.ua/ru/";
    private WebDriver driver;
    protected SoftAssert softAssert;

    protected WebDriver launch() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get(url);
        return driver;
    }

    protected WebDriver getDriver() throws InterruptedException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            launch();
            Thread.sleep(2000);
        }
        return driver;
    }
//    protected WebDriver getDriver() {
//        WebDriver currentWebDriver = drivers.get(Thread.currentThread().getId());
//        if (currentWebDriver == null) {
//            currentWebDriver = new ChromeDriver();
//            currentWebDriver.manage().window().maximize();
//            currentWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            drivers.put(Thread.currentThread().getId(), currentWebDriver);
//        }
//        return currentWebDriver;
//    }
//    @BeforeSuite
//    public void beforeSuite() {
//        WebDriverManager.chromedriver().setup();
//    }
//
////    @BeforeClass
////    public void beforeClass(ITestContext context) {
////        drivers = new HashMap<Long, WebDriver>();
////        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
////                url = entry.getValue();
////        }
////    }

//    @AfterClass(alwaysRun = true)
//    public void afterClass() {
//        driver.quit();
//    }

}

