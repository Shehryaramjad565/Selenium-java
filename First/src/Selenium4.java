import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;

import java.util.Set;

                                 
public class Selenium4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        //relative element finding 
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());
        
        
        WebElement text=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
//        driver.findElement(By.tagName("input")).toLeftof(text).click();
        driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
        
      
        
        
        
//        String titleZ=driver.getTitle();
//        System.out.println(titleZ);
        //multiple window
        driver.switchTo().newWindow(WindowType.TAB);
        
        Set<String> handles= driver.getWindowHandles();
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
//        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //assert on title of new window
        driver.get("https://rahulshettyacademy.com/");	
        String courseName=driver.findElement(By.xpath("//a[text()='All-Access Membership-Complete Access to 25+ Courses (and counting!)']")).getText();
        driver.switchTo().window((String) windowHandles[0]);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
        //        String title=driver.getTitle();
//        System.out.println(title);
        
//        assertEquals("Simple Page",title);

        
	}


}





