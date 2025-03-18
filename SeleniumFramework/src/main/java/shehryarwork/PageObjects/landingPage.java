//package shehryarwork.PageObjects;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class landingPage {
//
//	WebDriver driver;
//	
//	public landingPage(WebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver,this);
//	}
//	
//	@FindBy(id="name")
//	WebElement userName;
//	
//	@FindBy(id="email")
//	WebElement getEmail;
//	
//	@FindBy(id="form-submit")
//	WebElement Submit;
//	
//	@FindBy(linkText="Automation Practise - 1")
//	WebElement ClickOnAutomation;
//	
//	
//	public void LoginApplication(String Name, String Email) {
//		userName.sendKeys(Name);
//		getEmail.sendKeys(Email);
//		ClickOnAutomation.submit();
//		
//	}
//	
//
//	
//	public void gotosite() {
//		driver.get("https://rahulshettyacademy.com/");
//	}
//	
//
//	
//}










package shehryarwork.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shehryarwork.abstractcomponents.AbstractComponent;

public class landingPage extends AbstractComponent {

    public static WebDriver driver;

    public landingPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Practice")
    WebElement practiceLink;

    @FindBy(id = "name")
    WebElement userName;

    @FindBy(id = "email")
    WebElement userEmail;

    @FindBy(id = "form-submit")
    WebElement submitButton;
    
    @FindBy( partialLinkText = "Automation Practise - 1")
    WebElement automationPracticeLink;
    
    @FindBy(xpath="//h2[text()='Enter code here']")
    WebElement SendCodeText;
    


    public void goToSite() {
        driver.get("https://rahulshettyacademy.com/");
    }

    public ProductsCatalogs loginApplication(String name, String email) throws InterruptedException {
        // Navigate to Practice page
        practiceLink.click();
        
        // Fill the form
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        
        // Submit the form
        submitButton.click();
        
        // Navigate to Automation Practice page
//        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(automationPracticeLink)).click();
        ProductsCatalogs productObj= new ProductsCatalogs(driver);
        return productObj;
       
    }
    
    
    
    
    
    
    
    public String loginApplicationInvalidDate(String name, String email) throws InterruptedException {
        // Navigate to Practice page
        practiceLink.click();
        
        // Fill the form
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        
        // Submit the form
        submitButton.click();
//        Thread.sleep(20000);
        WebElement sendCodeElement=waitForElementToAppearWebElement(SendCodeText);
        return sendCodeElement.getText();
        
        // Navigate to Automation Practice page
//        Thread.sleep(2000);

       
    }
   


}