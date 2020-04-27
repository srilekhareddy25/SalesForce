package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyLoader;

public class Contacts extends SFReuseMethods {
	
	static void createNewContact() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
			driver.findElement(By.xpath("//input[@name='new']")).click();
			
			driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(pl.getProperty("Lastname"));
	     
			 driver.findElement(By.xpath("//a[@id='con4_lkwgt']//img[@class='lookupIcon']")).click();
			 ArrayList<String> windowTabs = new ArrayList(driver.getWindowHandles());
				 
				driver.switchTo().window(windowTabs.get(1));
				 Thread.sleep(5000);
				//waitElementToVisibleLocated(By.xpath("//frame[@id='resultsFrame']"));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@id='resultsFrame']")));
				 Thread.sleep(5000);
				driver.findElement(By.xpath("//a[contains(text(),'sre')]")).click();
				Thread.sleep(3000);
				//driver.switchTo().defaultContent();
				//driver.close();
				driver.switchTo().window(windowTabs.get(0));
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
								
	     Thread.sleep(5000);
	 	driver.quit();
	 		
	 }
	
	static void createNewView() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//a[contains(text(),'Create New View')]"));
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			
			driver.findElement(By.xpath("//input[@id='fname']")).clear();
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(pl.getProperty("Viewname"));
			driver.findElement(By.xpath("//input[@id='devname']")).clear();
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(pl.getProperty("Viewuniquename"));
			driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
	
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
	
	static void checkRecentCreatedcontact() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	    
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='hotlist_mode']"));
			
			WebElement recentlyviewed = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
			recentlyviewed.click();
			Select recentcontacts = new Select(recentlyviewed);
			recentcontacts.selectByIndex(0);
			
			waitElementToVisibleLocated(By.xpath("//tr[@class='headerRow']//th[1]"));
			driver.findElement(By.xpath("//tr[@class='headerRow']//th[1]")).click();
			System.out.println("recently created contacts displayed");
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
	 	
	static void myContactsView() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	    
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			
			WebElement view = driver.findElement(By.xpath("//select[@id='fcf']"));
			view.click();
			Select mycontacts = new Select(view);
			mycontacts.selectByIndex(2);
			 driver.findElement(By.xpath("//input[@name='go']")).click();
			//a[@id='tryLexDialogX']
			//driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//input[@id='00B5w00000D6uGF_refresh']"));
			driver.findElement(By.xpath("//input[@id='00B5w00000D6uGF_refresh']")).click();
			System.out.println("my contacts displayed");
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
	
	static void viewAContact() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	    
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
			
			driver.findElement(By.xpath("//a[contains(text(),'gajjala')]")).click();
		
			waitElementToVisibleLocated(By.xpath("//h2[@class='topName']"));
			driver.findElement(By.xpath("//h2[@class='topName']")).click();
			System.out.println("contact info page displayed");
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
	
	static void cancelButtonInNewView() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//a[contains(text(),'Create New View')]"));
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			
			driver.findElement(By.xpath("//input[@id='fname']")).clear();
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(pl.getProperty("Viewname"));
			driver.findElement(By.xpath("//input[@id='devname']"));
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(pl.getProperty("Viewuniquename"));
			driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']")).click();
			
			waitElementToVisibleLocated(By.xpath("//h3[contains(text(),'Recent Contacts')]"));
			driver.findElement(By.xpath("//h3[contains(text(),'Recent Contacts')]")).click();
			
			System.out.println("contacts page is displayed without creating new view");
	
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
	
	static void saveAndNewButtonContacts() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
			driver.findElement(By.xpath("//input[@name='new']")).click();
			
			driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys(pl.getProperty("Contactlastname"));
			driver.findElement(By.xpath("//input[@id='con4']")).sendKeys(pl.getProperty("Accountname"));
			driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']")).click();
			
			System.out.println(driver.findElement(By.xpath("//div[@id='errorDiv_ep']")).getText());
			
			System.out.println("Test failed error message displayed");
			
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
	     
	static void errorMsgInNewView() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     PropertyLoader pl = new PropertyLoader();
	     
	     driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[@class='listRelatedObject contactBlock title']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("tryLexDialogX")).click();
			
			waitElementToVisibleLocated(By.xpath("//a[contains(text(),'Create New View')]"));
			driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
			
			driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(pl.getProperty("Viewuniquename"));
			driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
			
            System.out.println(driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]")).getText());
			
			System.out.println("error message displayed under view name field");
			
			 Thread.sleep(5000);
			 	driver.quit();
			 		
			 }
			
			
	 	

	public static void main(String[] args) throws Exception {
		
		createNewContact();
		createNewView();
		checkRecentCreatedcontact();
		myContactsView();
		viewAContact();
		cancelButtonInNewView();
		saveAndNewButtonContacts();
		 errorMsgInNewView();
		
	}

}
