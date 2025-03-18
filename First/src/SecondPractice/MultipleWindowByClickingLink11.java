

package SecondPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowByClickingLink11 {

	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("http://qaclickacademy.com/practice.php");
        
        WebElement parentBox = driver.findElement(By.id("gf-BIG"));
        

        List<WebElement> links = parentBox.findElements(By.xpath(".//table/tbody/tr/td[1]/ul/li/a"));


        for (int i = 0; i < links.size(); i++) {
        	WebElement parentBox1 = driver.findElement(By.id("gf-BIG"));
            
            links = parentBox1.findElements(By.xpath(".//table/tbody/tr/td[1]/ul/li/a")); // Re-fetch elements
            WebElement link = links.get(i);
            link.click();
            
            System.out.println("Child Window Title: " + driver.getTitle());
            driver.navigate().back();

        }


	}
}
