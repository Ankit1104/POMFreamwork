package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory : OR (object repo)
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[@class='column']/form/div/div[4]")
	WebElement login;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	
	public String checktitle() {
		
		return driver.getTitle();
	}
	
	public void login(String a, String b) {
		
		email.sendKeys(a);
		password.sendKeys(b);
		login.click();
	}
	
	
	
	
	
	
	

	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);	
		
	}
	
	
	
	
	

	

}
