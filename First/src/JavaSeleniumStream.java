//
//public class JavaSeleniumStream {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}






////package tests;


import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaSeleniumStream {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr/th[1]"))).click();

  
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elementsList.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList, "The table is not sorted correctly!");

     
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream()
                    .filter(s -> s.getText().contains("Rice"))
                    .map(JavaSeleniumStream::getPriceVeggie)
                    .collect(Collectors.toList());

            price.forEach(System.out::println);

            if (price.isEmpty()) {
                WebElement nextButton = driver.findElement(By.cssSelector("[aria-label='Next']"));
                if (nextButton.isEnabled()) {
                    nextButton.click();
                    Thread.sleep(1000); // Adding sleep to prevent stale element issues
                } else {
                    System.out.println("Reached the last page, but 'Rice' was not found.");
                    break;
                }
            }

        } while (price.isEmpty());

        driver.quit();
    }

    private static String getPriceVeggie(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
