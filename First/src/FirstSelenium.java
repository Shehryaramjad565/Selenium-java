import java.time.Duration;
//import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
//		
//		WebDriver driver= new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", "C:/Users/Public/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getTitle());
		driver.findElement(By.id("inputUsername")).sendKeys("ali");
		driver.findElement(By.name("inputPassword")).sendKeys("12345678");
		driver.findElement(By.className("signInBtn")).click();
//		System.out.println(By.cssSelector("p.error"));
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ahmed");
		driver.findElement(By.cssSelector("input[placeholder=Email]"));
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(4)")).sendKeys("939393434343");
		driver.findElement(By.className("reset-pwd-btn")).click();
		String password= getPassword(driver);
		System.out.println(password);
//		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//now go to login page and login with dynamic password
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
//		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) {
		String mypassword= driver.findElement(By.cssSelector("form p")).getText();
		String mypassword2= mypassword.split("'")[1];
//		mypassword2 =mypassword2[1]
		System.out.println(mypassword2);
		String password= mypassword.split("'")[1];
		System.out.println(password);
		
		return password;
		
	}

}
