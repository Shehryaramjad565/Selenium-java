import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MethodsInSeleniumPart12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Corrected JavaScriptExecutor usage
        JavascriptExecutor js = (JavascriptExecutor) driver; // Fixed the typo and missing semicolon

        // Example JavaScript execution
        js.executeScript("window.scrollBy(0,500);");

        // Close the driver after execution
//        driver.quit();
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        
        List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        
        int sum= 0;
        for(int i = 0; i<values.size(); i++) {
        	sum+=Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        
        int total=Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum, total);
        
		

	}

}
