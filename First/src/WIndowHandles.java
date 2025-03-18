//
//public class WindowHandles {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}















//import java.util.Iterator;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.Iterator;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WIndowHandles {
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Downloads/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
//        driver.findElement(By.cssSelector(".blinkingText")).click();
//
//        Set<String> windows = driver.getWindowHandles();  // [parentid, childid, subchildId]
//        Iterator<String> it = windows.iterator();
//        String parentId = it.next();
//        String childId = it.next();
//        driver.switchTo().window(childId);
//
//        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
//    }
//}

















import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WIndowHandles {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
//        driver.findElement(By.cssSelector(".blinkingText")).click();
//
//        Set<String> windows = driver.getWindowHandles();  // [parentid, childid, subchildId]
//        Iterator<String> it = windows.iterator();
//        String parentId = it.next();
//        String childId = it.next();
//        driver.switchTo().window(childId);
//
//        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        driver.findElement(By.className("blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();  // [parentid, childid, subchildId]
      Iterator<String> it = windows.iterator();
      String parentId = it.next();
      String childId = it.next();
      driver.switchTo().window(childId);
      String emailText=driver.findElement(By.cssSelector(".im-para.red")).getText();  
      
//        WebElement email=driver.findElement(By.id("username"));
        
        
    }
}

