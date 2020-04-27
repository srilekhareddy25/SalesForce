package testcases;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import util.PropertyLoader;

public class SF_UserMenu extends SFReuseMethods {
	
	static void userMenuDropDown() throws Exception {
		     loginToSF();
		     Thread.sleep(3000);
	    waitElementToVisible(driver.findElement(By.xpath("//span[@id='userNavLabel']")));
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
     
		Thread.sleep(5000);
		driver.quit();
			
	}
	
	static void developerConsole() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
	driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']")).click();
	
	ArrayList<String> windowTabs = new ArrayList(driver.getWindowHandles());
	System.out.println(windowTabs.size()); 
	driver.switchTo().window(windowTabs.get(1));
	Thread.sleep(2000);
	driver.close();
	driver.switchTo().window(windowTabs.get(0));
	
	Thread.sleep(5000);
	driver.quit();
		
}

	static void logOut() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	
	waitElementToVisibleLocated(By.xpath("//input[@id='username']"));
	
	Thread.sleep(5000);
	driver.quit();
		
}
	
	static void myProfile() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	     PropertyLoader pl = new PropertyLoader();
	driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
	waitElementToVisibleLocated(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
	Thread.sleep(3000);
	//Adding Last name
    driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img")).click();
	driver.switchTo().frame("contactInfoContentId");
	
	//waitElementToVisibleLocated(By.xpath("//li[@id='aboutTab']"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[@id='aboutTab']")).click();
	
	driver.findElement(By.xpath("//input[@id='lastName']")).clear();
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(pl.getProperty("Lastname"));
	driver.findElement(By.xpath("//input[contains(@class,'zen-btn zen-primaryBtn zen-pas')]")).click();
	driver.switchTo().defaultContent();
	 Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame cke_reset')]")));
    Thread.sleep(1000);
	driver.findElement(By.xpath("/html[1]/body[1]")).sendKeys("Hi");
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
    Thread.sleep(2000);
    //Adding File
	 driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']")).click();
	 driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
	 driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys(pl.getProperty("File"));
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
	 Thread.sleep(3000);
	 //Adding photo
	WebElement ele = driver.findElement(By.xpath("//img[contains(@class,'chatter-photo')]"));
	Actions act = new Actions(driver);
	act.moveToElement(ele).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='uploadLink']")).click();
	driver.switchTo().frame("uploadPhotoContentId");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']")).sendKeys(pl.getProperty("File"));
	driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']")).click();
	Thread.sleep(5000);
	Actions act1 = new Actions(driver);
	act1.dragAndDropBy(driver.findElement(By.xpath("//div[contains(@class,'imgCrop_handle imgCrop_handleNW')]")), 10, 20);
	driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
	driver.switchTo().defaultContent();
	//Thread.sleep(3000);
	//deleting photo
//	WebElement ele1 = driver.findElement(By.xpath("//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@class='chatter-photo']"));
//	Actions act2 = new Actions(driver);
//	act2.moveToElement(ele).build().perform();
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//a[@id='deletePhoto']")).click();
//	Alert al = driver.switchTo().alert();
//	al.accept();
	
	Thread.sleep(6000);
	driver.quit();
		
}
	
	static void mySettings() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
	waitElementToVisibleLocated(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
	
	driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']")).click();
	driver.findElement(By.xpath("//a[@id='LoginHistory_font']")).click();
	Thread.sleep(2000);
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	WebElement display = driver.findElement(By.xpath("//div[@id='DisplayAndLayout']//a[contains(@class,'header setupFolder')]"));
    
	 js.executeScript("arguments[0].scrollIntoView();", display);
	 display.click();
	 
	 
	     waitElementToVisible(driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")));
	 
		driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']")).click();
		
		 waitElementToVisible(driver.findElement(By.xpath("//select[@id='p4']")));
		 
		 WebElement customapp = driver.findElement(By.xpath("//select[@id='p4']"));
			
			Select customappdd = new Select(customapp);
			customappdd.selectByIndex(8);
			
	    
	    driver.findElement(By.xpath("//option[contains(text(),'Reports')]")).click();
	    driver.findElement(By.xpath("//img[@class='rightArrowIcon']")).click();
	    
	    driver.findElement(By.xpath("//input[@name='save']")).click();
	    
	   
	    
	    driver.findElement(By.xpath("//div[@id='EmailSetup']//a[contains(@class,'header setupFolder')]")).click();
	    driver.findElement(By.xpath("//a[@id='EmailSettings_font']")).click();
	    driver.findElement(By.xpath("//input[@name='save']")).click();
	    
	    driver.findElement(By.xpath("//div[@id='CalendarAndReminders']//a[contains(@class,'header setupFolder')]")).click();
	    driver.findElement(By.xpath("//a[@id='Reminders_font']")).click();
	    driver.findElement(By.xpath("//input[@id='testbtn']")).click();
	    
	    
	    
			
	Thread.sleep(5000);
	driver.quit();
		
}

	
	
	public static void main(String[] args) throws Exception {
		
		 userMenuDropDown();
		developerConsole();
		 logOut();
		 myProfile();
		mySettings();
		 

	}

}
