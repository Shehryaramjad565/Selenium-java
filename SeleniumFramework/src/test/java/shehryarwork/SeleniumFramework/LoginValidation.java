package shehryarwork.SeleniumFramework;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import shehryarwork.BaseTest.BaseTest;
import shehryarwork.PageObjects.CartPage;
import shehryarwork.PageObjects.CheckOutPage;
import shehryarwork.PageObjects.ProductsCatalogs;


import java.io.IOException;

import shehryarwork.PageObjects.ProductsCatalogs;

//@Test
public class LoginValidation extends BaseTest {
	@Test(groups= {"negativeTesting"})
	public void LoginValidationMethod() throws InterruptedException, IOException {
		
		String getproduct = launchApplication().loginApplicationInvalidDate("ali", "alikhanaj0@gmail.com");
		Assert.assertEquals(getproduct, "Enter code here");
	}
	
	
}
