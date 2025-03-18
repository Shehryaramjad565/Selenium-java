package SecondPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Stream14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 Convert List of Strings to Uppercase
		List<String> names = Arrays.asList("ali","ahmed","ajaz");
		
		List<String> uperName = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(uperName);
		
		
		
		
		

		//find even number from list 
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
		

		List<Integer> num2=numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		
		System.out.println(num2);
		
		
		
		
//		List<String> cars = {"Volvo", "BMW", "Ford", "Mazda"};
		 List<String> cars = Arrays.asList("Volvo", "BMW", "Ford", "Mazda");

		
		Optional<String> get=cars.stream().filter(n -> n.startsWith("F")).findFirst();
		
		
		System.out.println(get);
		
		
//		Count Elements Greater Than 50
		
		List<Integer> numbers2 = Arrays.asList(40, 55, 60, 20, 75);
		
		List<Integer> get2 = numbers2.stream().filter(n -> n>50).collect(Collectors.toList());
		
		
		System.out.println(get2);
		
		
		
		
//		Exercise 5: Sort a List in Ascending Order
		
		List<Integer> num3 = Arrays.asList(5, 2, 8, 1, 3);

		List<Integer> get3 = num3.stream().sorted( Collections.reverseOrder()).collect(Collectors.toList());
		
		System.out.println(get3);
		
		
		
		
		
		
//		Exercise 6: Find the Maximum Value in a List
		
		List<Integer> num4 = Arrays.asList(12, 45, 7, 89, 23);
		
		Optional<Integer> get4 = num4.stream().max(Integer :: compareTo);
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Public/chromedriver-win64/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
//        before click
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
        List<WebElement> BEelements = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:nth-child(1)"));
        
        List<String> BeforeClick = BEelements.stream().map(n-> n.getText()).collect(Collectors.toList());
		


//		After Click Elements
		 List<WebElement> AFelements = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:nth-child(1)"));
		
		 List<String> toList = AFelements.stream().map(n-> n.getText()).collect(Collectors.toList());
		List<String> AfterClick = toList.stream().sorted().collect(Collectors.toList());
		
		
		
		System.out.println(BeforeClick.getFirst());
		System.out.println(AfterClick.getFirst());
		
		Assert.assertEquals(BeforeClick, AfterClick);
		
		
		
		//get the price of item by name
		
//		while(true) {
//		 List<WebElement> getelements = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:nth-child(1)"));
////		boolean found = false;
//		Optional<WebElement> selectedElement = getelements.stream()
//		        .filter(n -> n.getText().trim().equalsIgnoreCase("Rice"))
//		        .findFirst();  // Get the first match
//
//		// If "Rice" is found, locate the next sibling column
//		if (selectedElement.isPresent()) {
//		    WebElement nextCell = selectedElement.get().findElement(By.xpath("./following-sibling::td[1]"));
//		    System.out.println("price is" + nextCell.getText());
////		    found=true;
//		    break;
//		}
//		else {
////		    System.out.println("Rice not found!");
//			driver.findElement(By.cssSelector(".pagination.pull-right")).click();
//		}
//		
//		}
		
		
		
		
		
		
		
		while (true) {
		    // Get table rows again (to avoid stale element exception)
		    List<WebElement> getelements = driver.findElements(By.cssSelector(".table.table-bordered tbody tr td:nth-child(1)"));
		    
		    Optional<WebElement> selectedElement = getelements.stream()
		            .filter(n -> n.getText().trim().equalsIgnoreCase("Rice"))
		            .findFirst();  // Get the first match

		    // If "Rice" is found, locate the next sibling column and break the loop
		    if (selectedElement.isPresent()) {
		        WebElement nextCell = selectedElement.get().findElement(By.xpath("./following-sibling::td[1]"));
		        System.out.println("Price is: " + nextCell.getText());
		        break;  // Stop the loop when "Rice" is found
		    } else {
		        // Check if "Next Page" button exists and is clickable
		        List<WebElement> nextPageButton = driver.findElements(By.cssSelector(".pagination .next")); // Adjust selector if needed
		        if (nextPageButton.isEmpty()) {
		            System.out.println("❌ No more pages, 'Rice' not found!");
		            break;  // Stop if no next page
		        }
		        nextPageButton.get(0).click();  // Click next page
		    }
		}

		
		
		
	}
}
