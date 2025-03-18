import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:/Users/Public/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.cssSelector("[data-testid='to-testID-origin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Agra']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();

	}

}
//