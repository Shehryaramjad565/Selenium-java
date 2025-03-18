package first;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class fisttest {
	@Parameters({"URL"})
	@Test(priority=1)
	public void first(String url) {
		System.out.println("First test1");
		System.out.println(url);
	}
	
	
	@Test(priority = 3, groups = {"Smoke"})
	public void first1() {
		System.out.println("First test 3");
	}
	
	@Test(priority=2)
	public void first2() {
		System.out.println("First test 2");
	}
	
	
	@BeforeMethod
	public void beforemethod() {
		// TODO Auto-generated method stub
		System.out.println("its run before each method in of this file");

	}
	
	@BeforeClass
	public void beforeclass() {
		// TODO Auto-generated method stub
		System.out.println("its run before tests in this class");

	}
	
	@Test(groups={"Smoke"})
	public void testgroup() {
		// TODO Auto-generated method stub
		System.out.println("its a smoke test");

	}
	
	@Test(dependsOnMethods= {"first"})
	public void dependentOnMethod() {
		System.out.println("this method is bependend on another method other mathod should run first");
	}
	
	@Test(enabled=false)
	public void disableTest() {
		System.out.println("this test is disable");;
	}
	
	
	
	
	
	

	
	
}
