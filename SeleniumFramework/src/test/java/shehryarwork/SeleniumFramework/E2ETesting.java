package shehryarwork.SeleniumFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import shehryarwork.BaseTest.BaseTest;
import shehryarwork.PageObjects.CartPage;
import shehryarwork.PageObjects.CheckOutPage;
import shehryarwork.PageObjects.ProductsCatalogs;

public class E2ETesting extends BaseTest {
    String product1 = "Cucumber - 1 Kg";
    
    
    @DataProvider(name = "userData")
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataMap(System.getProperty("user.dir") 
                + "//src//test//java//shehryarwork//data//PurchaseOrder.json");
        return new Object[][] { { data.get(0) }, { data.get(1) } };
    }
    
    @Test(dataProvider = "userData", groups = {"Purchases"})
    public void ProductAddToCart(HashMap<String, String> input) throws IOException, InterruptedException {
        // Launch application and login using provided input
        ProductsCatalogs productObj = launchApplication().loginApplication(input.get("name"), input.get("email"));
        List<WebElement> products = productObj.getProducts();
        productObj.AddtoCart(input.get("productName"));
        productObj.clickOnCart();
        Thread.sleep(20000); // Consider replacing Thread.sleep with explicit wait
        
        CartPage cartObj = new CartPage(driver);
        String cartNumber = cartObj.productInCartMethod();
        System.out.println(cartNumber);
        int cartInt = Integer.parseInt(cartNumber);
        Assert.assertTrue(cartInt > 0, "Products are more than 1, passed");
    }
    
    
  
    
    
  @Test(dataProvider = "userData")
  public void mainTest(HashMap<String, String> input) throws IOException, InterruptedException {

      ProductsCatalogs productObj = launchApplication().loginApplication(input.get("name"), input.get("email"));
      List<WebElement> products = productObj.getProducts();
      productObj.AddtoCart(input.get("productName"));
      productObj.clickOnCart();
      productObj.ProceedInCheckbox();
      
      CartPage cartObj = new CartPage(driver);
      String getProductInCart = cartObj.CheckProductInCart();
//      Assert.assertEquals(getProductInCart, product1);

      CheckOutPage checkOutObj = new CheckOutPage(driver);
      checkOutObj.CheckOutMethod();

      System.out.println("Test Completed Successfully!");
  }
    
    
}











//
//package shehryarwork.SeleniumFramework;
//
//import java.io.IOException;
//import java.util.List;
//import org.openqa.selenium.*;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import shehryarwork.BaseTest.BaseTest;
//import shehryarwork.PageObjects.CartPage;
//import shehryarwork.PageObjects.CheckOutPage;
//import shehryarwork.PageObjects.ProductsCatalogs;
//
//public class E2ETesting extends BaseTest {
//	String product1 = "Beetroot - 1 Kg";
//	
//	
//	
//    @Test
//    public void ProductAddToCart() throws IOException, InterruptedException {
//       
//
//        ProductsCatalogs productObj = launchApplication().loginApplication("ali", "alikhanaj00@gmail.com");
//        List<WebElement> products = productObj.getProducts();
//        productObj.AddtoCart(product1);
//        productObj.clickOnCart();
//        Thread.sleep(20000);
////        String number= productInCartMethod();
//        String CartNumber=launchApplication().productInCartMethod();
//        int CartInt=Integer.parseInt(CartNumber);
//        Assert.assertTrue(CartInt>1, "product are more then 1 passed");
//    }
//	
	
	
	
	
	
	
//  
    
    
    
//}







       
       
       
       
       
       
       
       
        
//        driver.get("https://rahulshettyacademy.com/");
//
//        // Wait for "Practice" link and click
//        WebElement practiceLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice")));
//        practiceLink.click();
//
//        // Wait and fill the form
//        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
//        nameInput.sendKeys("ali");
//
//        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
//        emailInput.sendKeys("alikhanaj00@gmail.com");
//
//        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("form-submit")));
//        submitButton.click();
//
//        // Wait for "Automation Practise - 1" link and click
//        WebElement autoPracticeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Automation Practise - 1")));
//        autoPracticeLink.click();

        // Ensure page has loaded before searching for products
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product")));
//
//        List<WebElement> products = driver.findElements(By.cssSelector(".product"));
//        System.out.println("Total Products: " + products.size());
        

        
        
        // Adding "Beetroot - 1 Kg" to cart
//        addToCart(driver, wait, products, product1);
//
//        // Adding "Cauliflower - 1 Kg" to cart
//        addToCart(driver, wait, products, product2);

        // driver.quit(); // Uncomment to close browser
        
        
//        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
//        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

//        List<WebElement> productNames = driver.findElements(By.cssSelector("td [class='product-name']"));
//        List<WebElement> productNames = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("td [class='product-name']")));
////        System.out.println("Total Products: " + productNames.);
//        String first="";
//        for (int i=0; i<productNames.size(); i++) {
//        	first=productNames.getFirst().getText();
////        	System.out.println(first);
//        }
        
        
        
     
        
        
        
        
        
        
        
        
        


//    public static void addToCart(WebDriver driver, WebDriverWait wait, List<WebElement> products, String itemName) {
//        for (WebElement product : products) {
//            String productName = product.findElement(By.cssSelector("h4")).getText();
//            if (productName.equals(itemName)) {
//                WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(product.findElement(By.xpath(".//button[text()='ADD TO CART']"))));
//                addToCartButton.click();
//                System.out.println("Clicked on: " + productName);
//                break;
//            }
//        }
//    }


  









