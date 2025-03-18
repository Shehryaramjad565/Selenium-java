package shehryarwork.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shehryarwork.abstractcomponents.AbstractComponent;


public class ProductsCatalogs extends AbstractComponent{
	
	WebDriver driver;
    public ProductsCatalogs(WebDriver driver) {
    	
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css= ".product")
//	public
    List <WebElement> products;
    
    By productBy= By.cssSelector(".product");
//    List<WebElement> 
    
//    WebElement getproduct=;
    		
    public List<WebElement> getProducts(){
    	waitForElementToAppear(productBy);
    	return products;
    }
    
    
    public void AddtoCart(String Product1) {
        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("h4")).getText();
            if (productName.equals(Product1)) {
//            	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(product.findElement(By.xpath(".//button[text()='ADD TO CART']"))));
//                addToCartButton.click();
            	waitForElemenTobeClickableWebElement(product.findElement(By.xpath(".//button[text()='ADD TO CART']")));
            	
                System.out.println("Clicked on: " + productName);
                break;
            }
        }
    }

}



