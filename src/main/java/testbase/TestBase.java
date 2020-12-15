package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException {
		
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"src/main/java/config/config.properties");
		prop = new Properties();
		prop.load(f);	
	}
 public static void intilizaion() {
	 
	 String browsername= prop.getProperty("browser");
	 
		 if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver.exe");
			 driver = new FirefoxDriver();	
			
		} else if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		} else {
			System.setProperty("webdriver.safari.driver", "D:\\SeleniumJars\\safaridriver");
			 driver = new SafariDriver();
		}
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait , TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("url"));
		
 }
} 
