package shehryarwork.PageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	 WebDriver driver;
	 public CheckOutPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 
	 }
//	 WebElement dropdownElement= driver.findElement(By.cssSelector("select"));
//     
//     Select dropdown= new Select(dropdownElement);
//     
//     dropdown.selectByVisibleText("Pakistan");
//     
//     driver.findElement(By.cssSelector("input[type$='checkbox']")).click();
//     
//     driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	 
	 @FindBy(css="select")
	 WebElement dropdownElement;
	 
	 @FindBy(css="input[type='checkbox']")
	 WebElement TermAndCondition;
	 
	 @FindBy(xpath="//button[text()='Proceed']")
	 WebElement CheckoutButton;
	 
	 public void CheckOutMethod() {
		 Select dropdown= new Select(dropdownElement);
	     
	     dropdown.selectByVisibleText("Pakistan");
	     TermAndCondition.click();
	     CheckoutButton.click();
	     
	 }
	 
	 
	 
}
