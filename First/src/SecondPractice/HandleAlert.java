package SecondPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("ali");
        
        driver.findElement(By.id("alertbtn")).click();
        
        driver.switchTo().alert().accept();
        
        
        
        
        
	}

}
