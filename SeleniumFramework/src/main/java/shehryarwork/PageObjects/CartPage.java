package shehryarwork.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shehryarwork.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    @FindBy(xpath="//button[text()='Place Order']")
    WebElement placeOrder;
    
    @FindBy(xpath="//tbody/tr[1]/td[3]")
    WebElement ProductInCartNumber;
//    By productBy= By.cssSelector(".product");
    
    
    By CartProduct=By.cssSelector("td [class='product-name']");
    
    public String CheckProductInCart() {
    	
//      List<WebElement> productNames = driver.findElements(By.cssSelector("td [class='product-name']"));
//      List<WebElement> productNames = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("td [class='product-name']")));
    	List<WebElement> productNames= presenceOfAllElementsLocatedByMethod(CartProduct);
    	//      System.out.println("Total Products: " + productNames.);
      String first="";
      for (int i=0; i<productNames.size(); i++) {
      	first=productNames.getFirst().getText();
//      	System.out.println(first);
      }
      placeOrder.click();
      return first;
    }


    
    
    
    
    
    
    public String productInCartMethod() {
        // Use an explicit wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productCartElement = wait.until(
                ExpectedConditions.visibilityOf(ProductInCartNumber)
        );
        return productCartElement.getText();
    }

}
