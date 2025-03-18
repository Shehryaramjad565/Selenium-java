package shehryarwork.abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
//	driver.findElement(By.cssSelector("input[type$='checkbox']")).click();
//	    input[type$='checkbox']
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement checkbox;
	
//	driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement proceedInCheckbox;
	
	public void clickOnCart() {
		checkbox.click();
	}
	
	public void ProceedInCheckbox() {
		proceedInCheckbox.click();
	}
	
//	public void ProceedInCheckbox() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(proceedInCheckbox)).click();
//	}


	public void waitForElementToClickable(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findby)).click();
	}
	public void waitForElemenTobeClickableWebElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	
	public void waitForElementToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public WebElement waitForElementToAppearWebElement(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(ExpectedConditions.visibilityOf(element)); // Correct method
	}

	
	public List<WebElement> presenceOfAllElementsLocatedByMethod(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findby));
	}
}
