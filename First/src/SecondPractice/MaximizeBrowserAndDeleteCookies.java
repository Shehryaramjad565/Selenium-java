//
//package SecondPractice;
//
//import java.io.File;
//
////import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//
//public class MaximizeBrowserAndDeleteCookies {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://rahulshettyacademy.com/");
//        driver.manage().deleteAllCookies();
//        
////        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
////        FileUtils.copyFile(src, new File("C:\\Users\\rahul\\screenshot.png"));
//        
////        File file=driver.getScreenshotAs(OutputType.FILE);
//        
////        FileUtils.copyFile(file, new File("logo.png"));
//        
//        
//        
//        
//        
//     // Finding all the available links on webpage
//        List<WebElement> links = driver.findElements(By.tagName("a"));
//
//
//        // Iterating each link and checking the response status
//        for (WebElement link : links) {
//        String url = link.getAttribute("href");
//        verifyLink(url);
//        }
//
//
//        driver.quit();
//        }
//
//
//        public static void verifyLink(String url) {
//
//        URL link = new URL(url);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
//        httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
//        httpURLConnection.connect();
//        }
//        
//
//
//	}
//
//}





package SecondPractice;

import java.io.File;
import java.io.IOException;  // Needed for exception handling
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeBrowserAndDeleteCookies {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/");
        driver.manage().deleteAllCookies();

        // Finding all the available links on webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Iterating each link and checking the response status
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyLink(url);
        }

        driver.quit();
    }

    public static void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();
            
            
            int getRes = httpURLConnection.getResponseCode();
            
            if (getRes>400) {
            	System.out.println("this is broken link " + link.getPath() + "and is broken code is" + getRes);
            }
            else {
            	System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + " is working");
            	}
        } 
       
        
        
        catch (IOException e) {
            System.out.println("Invalid URL or Connection Error: " + url);
        }
    }
}

