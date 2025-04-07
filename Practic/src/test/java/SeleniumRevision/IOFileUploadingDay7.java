package SeleniumRevision;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import org.testng.Assert;
//
//public class IOFileUploadingDay7 {
//
//    public static void main(String[] args) throws InterruptedException, IOException {
//
//        String downloadPath = System.getProperty("user.dir");
////        System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
//
//        // Set Chrome preferences for download behavior
//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", downloadPath);
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//
//        // Launch browser
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://www.ilovepdf.com/jpg_to_pdf");
//
//        // Click the upload button
//        driver.findElement(By.id("pickfiles")).click();
//        Thread.sleep(3000);
//
//        // Upload file using AutoIt script
//        Runtime.getRuntime().exec("D:\\Downloads\\myauto.au3");
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
//
//        // Click the convert button
//        driver.findElement(By.id("processTaskTextBtn")).click();
//
//        // Wait for download link and click
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
////        driver.findElement(By.linkText("Download Now")).click();
//
//        Thread.sleep(5000);
//
//        // Verify and delete the downloaded file
//        File file = new File(downloadPath + "/jpgimg.pdf");
//        if (file.exists()) {
//            Assert.assertTrue(file.exists());
//            if (file.delete()) {
//                System.out.println("File deleted successfully.");
//            }
//        }
//
//        driver.quit();
//    }
//}




// Make sure the package name is correct or remove it if notneeded
// package SeleniumRevision;












//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import org.testng.Assert;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class IOFileUploadingDay7 {
//
//    public static void main(String[] args) throws InterruptedException, IOException {
//
//        // Download path where file will be saved
//        String downloadPath = System.getProperty("user.dir");
//
//        // Path to ChromeDriver
////        System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//
//        // Set Chrome preferences for file download
//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", downloadPath);
//
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//
//        // Start Chrome with the given options
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://www.ilovepdf.com/jpg_to_pdf");
//
//        // Click upload button
//        driver.findElement(By.id("pickfiles")).click();
//        Thread.sleep(3000); // Let the file dialog open
//
//        // Run AutoIt script to upload file
//        Runtime.getRuntime().exec("D:\\Downloads\\muauto.exe"); // Make sure it's compiled to .exe
//
//        // Wait for the convert button to become clickable
////        WebDriverWait wait = new WebDriverWait(driver, 20); // Increased to 20 for slower internet
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
//        Thread.sleep(5000);
//
//        // Click on Convert to PDF
//        driver.findElement(By.id("processTaskTextBtn")).click();
//
//        // Wait for download link (Optional – ilovepdf might auto-download)
//        Thread.sleep(10000); // Wait for download to complete
//
//        // Check if the file is downloaded (you may need to confirm the file name)
//        File file = new File(downloadPath + "/jpgimg.pdf"); // Change filename if it's different
//        if (file.exists()) {
//            Assert.assertTrue(file.exists());
//            System.out.println("Downloaded file found.");
//            if (file.delete()) {
//                System.out.println("File deleted successfully.");
//            }
//        } else {
//            System.out.println("File not found.");
//        }
//
//        // Close browser
//        driver.quit();
//    }
//}










import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITFileUpload {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        try {
            driver.get("https://www.ilovepdf.com/jpg_to_pdf");
            
            // Trigger file upload dialog
            driver.findElement(By.id("pickfiles")).click();
            Thread.sleep(2000); // Wait for dialog
            
            // Execute AutoIT script (CRITICAL FIXES APPLIED)
            Runtime.getRuntime().exec("D:\\Downloads\\myauto2.exe");
            
            // Wait for conversion
            Thread.sleep(5000);
            
            // Start conversion
            driver.findElement(By.id("processTaskTextBtn")).click();
            
            // Verify download (adjust path as needed)
            Thread.sleep(15000);
            File downloadedFile = new File(System.getProperty("user.dir") + "/jpgimg.pdf");
            if(downloadedFile.exists()) {
                System.out.println("File downloaded successfully!");
                downloadedFile.delete();
            }
            
        } finally {
            driver.quit();
        }
    }
}