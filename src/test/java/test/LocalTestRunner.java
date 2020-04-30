package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

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
     public HomePage loadApplication(){return new HomePage();}
}

