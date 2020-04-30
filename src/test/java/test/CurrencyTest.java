package test;

import org.testng.annotations.Test;

public class CurrencyTest extends LocalTestRunner{
 @Test(description = "Check if product currency is correct")
 public void checkProductCurrency()
 {
    loadApplication();

 }
}
