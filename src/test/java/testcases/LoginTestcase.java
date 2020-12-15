package testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.TestBase;

public class LoginTestcase extends TestBase{
	
	LoginPage Lp = new LoginPage(); // Object of login page class
	
	public LoginTestcase() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilizaion();	
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	 
	@Test (priority=1)
	public void checkpagetitletest() {
		String Title= Lp.checktitle();
		Assert.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test (priority=2)
	public void logintest() {
		Lp.login(prop.getProperty("username"), prop.getProperty("password"));
		String logout= driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).getText();
		Assert.assertEquals(logout, "Log Out");
	}
	

	

}
