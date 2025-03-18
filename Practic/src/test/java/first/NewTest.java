package first;

import org.testng.annotations.Test;


public class NewTest {
	
  @Test(groups={"Smoke"})
  public void f() {
	  System.out.println("first test");
  }
}
