package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyLoader;

public class Leads extends SFReuseMethods{
	
	static void leadHomePage() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			String expected = "Leads";
			
		      String actual = driver.findElement(By.xpath("//h1[@class='pageType']")).getText();
				
				if(actual.equals(expected)) {
					System.out.println("leads home page pass");
				}
				else
					System.out.println("fail");
				
				
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	
	static void leadDropDown() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			driver.findElement(By.xpath("//select[@id='fcf']")).click();
	     
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	 	
	static void todaysLeadPage() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			
			WebElement leadsviews = driver.findElement(By.xpath("//select[@id='fcf']"));
			leadsviews.click();
			Select todaysleads = new Select(leadsviews);
			todaysleads.selectByIndex(3);
			driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]")).click();
			
			waitElementToVisibleLocated(By.xpath("//input[@id='00B5w00000D6uFY_refresh']"));
			driver.findElement(By.xpath("//input[@id='00B5w00000D6uFY_refresh']")).click();
			
			System.out.println("todays leads page displayed");
	     
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	
	static void newButtonLeadsHome() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//input[contains(@name,'new')]"));
			driver.findElement(By.xpath("//input[contains(@name,'new')]")).click();
			
			driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys(pl.getProperty("Leadlastname"));
			driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys(pl.getProperty("Leadcompanyname"));
			driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']")).click();
	
			    String expected = "ABCD";
			
		      String actual = driver.findElement(By.xpath("//h2[@class='topName']")).getText();
			
			      if(actual.equals(expected)) {
					System.out.println("newly created lead details page displayed");
			}
				else
					System.out.println("fail");
				
				
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	
	static void goButtonfunc() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			
			WebElement leadsviews = driver.findElement(By.xpath("//select[@id='fcf']"));
			leadsviews.click();
			Select unreadleads = new Select(leadsviews);
			unreadleads.selectByIndex(1);
			driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]")).click();
			driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			//waitElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pl.getProperty("Username"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pl.getProperty("Password"));
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			
			waitElementToVisibleLocated(By.xpath("//img[@class='allTabsArrow']"));
			
			driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='listRelatedObject leadBlock title']")).click();
			//Thread.sleep(2000);
			//driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			driver.findElement(By.xpath("//span[contains(@class,'fBody')]//input[contains(@name,'go')]")).click();
			
			
			waitElementToVisibleLocated(By.xpath("//input[@id='00B5w00000D6uFK_refresh']"));
			driver.findElement(By.xpath("//input[@id='00B5w00000D6uFK_refresh']")).click();
			
			System.out.println("click on go button took to page left in last session, my unread leads page displayed");
	     
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	
	 	
	     

	public static void main(String[] args) throws Exception {
		
		leadHomePage();
		leadDropDown();	
		todaysLeadPage();
		newButtonLeadsHome();
		//goButtonfunc();

	}

}
