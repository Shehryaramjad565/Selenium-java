import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebdriverTechniques {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement  getdropdown =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        
    	Select dropdown = new Select(getdropdown);
    	dropdown.selectByIndex(3);
    	System.out.println(dropdown.getFirstSelectedOption().getText());

	}

}
