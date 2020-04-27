package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.PropertyLoader;

public class SFReuseMethods {
	
	public static WebDriver driver = null;
	
static void launchSF() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/");
}

	static void loginToSF() {
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		WebDriverManager.firefoxdriver().setup();
     	driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/");
		PropertyLoader pl = new PropertyLoader();
		 waitElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pl.getProperty("Username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pl.getProperty("Password"));
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		//waitElementToVisible(driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")));
	}
	
	static void waitElementToVisible(WebElement eleToWait) {
		WebDriverWait wait = new WebDriverWait(SFReuseMethods.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eleToWait));
		
	}
	
	static void waitElementToVisibleLocated(By eleToWait) {
		WebDriverWait wait = new WebDriverWait(SFReuseMethods.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleToWait));
		
	}
	
	static void quitBrowser(){
		driver.quit();
	}
	

}
