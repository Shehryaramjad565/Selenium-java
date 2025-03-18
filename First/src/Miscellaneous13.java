//
//
//import java.io.File;  // Corrected File import
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;  // Import for FileUtils
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Proxy;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class Miscellaneous13 {
//    public static void main(String[] args) throws IOException {
//        // Set Chrome options
//        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//
//        // Set Proxy   
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("203.0.113.45:8080"); // Replace with an actual proxy IP and port
//        options.setProxy(proxy); // Correct method to set proxy
//
//        // Set ChromeDriver path
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
//
//        // Launch Chrome with the configured options
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://expired.badssl.com/");
//        driver.manage().window().maximize();
//
//        // Deleting all cookies
//        driver.manage().deleteAllCookies();
//        
//        // Deleting a specific cookie
//        driver.manage().deleteCookieNamed("sessionKey");
//
//        // Take a screenshot
//        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file, new File("D://screenshot.png"));
//
//        // Print page title
//        System.out.println(driver.getTitle());
//
//        // Close the driver
//        driver.quit();
//    }
//}






//import java.io.File;  // Corrected File import
//import java.io.IOException;
//
import org.apache.commons.io.FileUtils;  // Import for FileUtils
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;          // Add this import
import java.nio.file.StandardCopyOption;  // Add this

import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;

// ... other imports remain the same

public class Miscellaneous13 {
    public static void main(String[] args) throws IOException {
        // ... existing code ...
    	
    	
      ChromeOptions options = new ChromeOptions();
      options.setAcceptInsecureCerts(true);

      // Set Proxy   
      Proxy proxy = new Proxy();
      proxy.setHttpProxy("203.0.113.45:8080"); // Replace with an actual proxy IP and port
      options.setProxy(proxy); // Correct method to set proxy

      // Set ChromeDriver path
      System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");

      // Launch Chrome with the configured options
      WebDriver driver = new ChromeDriver(options);
      driver.get("https://expired.badssl.com/");
      driver.manage().window().maximize();

      // Deleting all cookies
      driver.manage().deleteAllCookies();
      
      // Deleting a specific cookie
      driver.manage().deleteCookieNamed("sessionKey");

        // Take screenshot (modified)
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(
            srcFile.toPath(), 
            new File("D://screenshot.png").toPath(), 
            StandardCopyOption.REPLACE_EXISTING
        );

        // ... rest of the code ...
    }
}