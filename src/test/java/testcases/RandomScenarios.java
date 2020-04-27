package testcases;

import org.openqa.selenium.By;

import util.PropertyLoader;

public class RandomScenarios  extends SFReuseMethods {
	
	static void fnLnHomePage() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			System.out.println(driver.findElement(By.xpath("//span[@id='userNavLabel']")).getText());
			driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).click();
			Thread.sleep(2000);
			
			waitElementToVisibleLocated(By.xpath("//span[@id='tailBreadcrumbNode']"));
			driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).click();
	     System.out.println("my profile page displayed with same information");
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	
	static void updatedLastName() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//li[@id='home_Tab']//a[contains(text(),'Home')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			driver.findElement(By.xpath("//h1[@class='currentStatusUserName']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img")).click();
			driver.switchTo().frame("contactInfoContentId");
			
			//waitElementToVisibleLocated(By.xpath("//li[@id='aboutTab']"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
			
			driver.findElement(By.xpath("//input[@id='lastName']")).clear();
			driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("GS");
			driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
			driver.switchTo().defaultContent();
		
			System.out.println(driver.findElement(By.xpath("//span[@id='userNavLabel']")).getText());
	        System.out.println("Last name is updated everywhere");
	     
	     
	     Thread.sleep(5000);
		 	driver.quit();
		 		
		 }
	
	static void tabCustomization() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	     waitElementToVisibleLocated(By.xpath("//input[@name='customize']"));
	     driver.findElement(By.xpath("//input[@name='customize']")).click();
	     waitElementToVisibleLocated(By.xpath("//option[contains(text(),'Assets')]"));
	     driver.findElement(By.xpath("//option[contains(text(),'Assets')]")).click();
	     driver.findElement(By.xpath("//img[@class='leftArrowIcon']")).click();
	     driver.findElement(By.xpath("//input[@name='save']")).click();
	     System.out.println("Assets is removed from tab bar");
	     //logout and relogin
	     driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
	     driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	     waitElementToVisibleLocated(By.xpath("//input[@id='username']"));
	    
	     driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pl.getProperty("Username"));
	     driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pl.getProperty("Password"));
		 driver.findElement(By.xpath("//input[@id='Login']")).click();
	     System.out.println("Assets is not present in the tab bar");
	     Thread.sleep(5000);
	     
	     //reverse it to get result in next run
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	     waitElementToVisibleLocated(By.xpath("//input[@name='customize']"));
	     driver.findElement(By.xpath("//input[@name='customize']")).click();
	     waitElementToVisibleLocated(By.xpath("//option[contains(text(),'Assets')]"));
	     driver.findElement(By.xpath("//option[contains(text(),'Assets')]")).click();
	     driver.findElement(By.xpath("//img[contains(@class,'rightArrowIcon')]")).click();
	     driver.findElement(By.xpath("//input[@name='save']")).click();
	     System.out.println("Assets is added to the tab bar");
	    
	     Thread.sleep(5000);
		 	driver.quit(); 		
		 }
	   
	
	public static void main(String[] args) throws Exception {
		
		updatedLastName();
		fnLnHomePage();
		tabCustomization();

	}

}
