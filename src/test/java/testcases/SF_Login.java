package testcases;

import org.openqa.selenium.By;

import util.PropertyLoader;

public class SF_Login extends SFReuseMethods {
	
	static void clearPasswordField() throws Exception {
		launchSF();
		
		PropertyLoader pl = new PropertyLoader();
		 waitElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pl.getProperty("Username"));
		
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		String excpected = "Please enter your password.";
        String actual = driver.findElement(By.xpath("//div[@id='error']")).getText();
		
		if(actual.equals(excpected)) {
			System.out.println("Enter password : pass");
		}
		else
			System.out.println("fail");
		Thread.sleep(5000);
		driver.quit();
			
	}
	
	static void remembermeCheck() throws Exception {
		launchSF();
		
		PropertyLoader pl = new PropertyLoader();
		 waitElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pl.getProperty("Username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pl.getProperty("Password"));
		driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		waitElementToVisible(driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		 //waitElementToVisible(driver.findElement(By.xpath("//span[@id='idcard-identity']")));
		waitElementToVisibleLocated(By.xpath("//span[@id='idcard-identity']"));
		//Thread.sleep(3000);
		String excpected = "srilekha.g@salesforce.com";
        String actual = driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText();
		if(actual.equals(excpected)) {
			System.out.println("Verify user name : pass");
		}
		else
			System.out.println("fail");
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	static void forgotPassword() throws Exception {
		launchSF();
		PropertyLoader pl = new PropertyLoader();
		
		 waitElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
		 driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		 waitElementToVisible(driver.findElement(By.xpath("//input[@id='un']")));
		 driver.findElement(By.xpath("//input[@id='un']")).sendKeys(pl.getProperty("Username"));
		 driver.findElement(By.xpath("//input[@id='continue']")).click();
		 waitElementToVisible(driver.findElement(By.xpath("//p[contains(text(),'ve sent you an email with a link to finish rese')]")));
		 
		 String excpected = "We’ve sent you an email with a link to finish resetting your password.";
	        String actual = driver.findElement(By.xpath("//p[contains(text(),'ve sent you an email with a link to finish rese')]")).getText();
			if(actual.equals(excpected)) {
				System.out.println("Reset password message : pass");
			}
			else
				System.out.println("fail");
			
			Thread.sleep(5000);
			driver.quit();
			
			 
	}
	
	
	static void wrongLogin() throws Exception {
		launchSF();
		PropertyLoader pl = new PropertyLoader();
		 waitElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("22131");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		String excpected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        String actual = driver.findElement(By.xpath("//div[@id='error']")).getText();
		
		if(actual.equals(excpected)) {
			System.out.println("wrong login error message : pass");
		}
		else
			System.out.println("fail");
		
		Thread.sleep(5000);
		driver.quit();
		
	}
		

	public static void main(String[] args) throws Exception {
		
		clearPasswordField();
		loginToSF();
		Thread.sleep(5000);
		driver.quit();
		remembermeCheck();
		forgotPassword();
		wrongLogin();
	

		
	}

}
