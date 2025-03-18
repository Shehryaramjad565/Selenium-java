package SecondPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

public class CartificationHandling13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
        
        ChromeOptions handleSSL= new ChromeOptions();
        handleSSL.setAcceptInsecureCerts(true);
        
        ChromeDriver driver = new ChromeDriver(handleSSL);
        
      
        
        driver.get("https://expired.badssl.com/");
		System.out.println("The page title is : " +driver.getTitle());
	
	}

}
