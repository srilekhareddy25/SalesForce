package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyLoader;

public class CreateAccount extends SFReuseMethods {

	static void createanAccount() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
	  PropertyLoader pl = new PropertyLoader();
	driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	Thread.sleep(2000);
	
	
	
	driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("tryLexDialogX")).click();
	
	
	waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
	
	driver.findElement(By.xpath("//input[@name='new']")).click();
	
   waitElementToVisibleLocated(By.xpath("//input[@id='acc2']"));
	
	driver.findElement(By.xpath("//input[@id='acc2']")).sendKeys(pl.getProperty("Accountname"));
	
	 WebElement type = driver.findElement(By.xpath("//select[@id='acc6']"));
		type.click();
		Select techpartner = new Select(type);
		techpartner.selectByVisibleText("Technology Partner");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement priorioty = driver.findElement(By.xpath("//select[@id='00N5w00000HXja4']"));
	    
		 js.executeScript("arguments[0].scrollIntoView();", priorioty);
		 priorioty.click();
		 Select pr = new Select(priorioty);
		pr.selectByIndex(1);
		
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']")).click();
		
	
	Thread.sleep(5000);
	driver.quit();
		
}
	
	static void newView() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
		  PropertyLoader pl = new PropertyLoader();
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		
		
		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		
		waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(pl.getProperty("Viewname"));
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys(pl.getProperty("Viewuniquename"));
		driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']")).click();
		
	Thread.sleep(5000);
	driver.quit();
		
}
	
	static void editNewView() throws Exception {
	     loginToSF();
	     Thread.sleep(5000);
	     
		  PropertyLoader pl = new PropertyLoader();
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		
		waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
		driver.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(pl.getProperty("Viewname1"));
		
		WebElement field = driver.findElement(By.xpath("//select[@id='fcol1']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("arguments[0].scrollIntoView();", field);
		 field.click();
		 
				Select an = new Select(field);
				an.selectByIndex(1);
				
				WebElement operator = driver.findElement(By.xpath("//select[@id='fop1']"));
				
				operator.click();
				 
						Select co = new Select(operator);
						co.selectByIndex(3);
		 driver.findElement(By.xpath("//input[@id='fval1']")).clear();
	     driver.findElement(By.xpath("//input[@id='fval1']")).sendKeys("a");
	     driver.findElement(By.xpath("//div[@class='pbHeader']//input[1]")).click();
						
		
	Thread.sleep(5000);
	driver.quit();
		
}
	
	static void mergeAccounts() throws Exception {
	     loginToSF();
	     Thread.sleep(5000);
	     
	driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("tryLexDialogX")).click();

	waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
	driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
	
	waitElementToVisibleLocated(By.xpath("//input[@id='srch']"));
	driver.findElement(By.xpath("//input[@id='srch']")).sendKeys("sr");
	driver.findElement(By.xpath("//div[contains(@class,'pbWizardBody')]//input[contains(@name,'srchbutton')]")).click();
	driver.findElement(By.xpath("//input[@id='cid0']")).click();
	driver.findElement(By.xpath("//input[@id='cid1']")).click();
	driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]")).click();
	Thread.sleep(2000);
	WebElement merge = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 js.executeScript("arguments[0].scrollIntoView();", merge);
	 merge.click();
	 Alert al = driver.switchTo().alert();
		al.accept();
	
	
	Thread.sleep(5000);
	driver.quit();
		
}
	static void accountReport() throws Exception {
	     loginToSF();
	     Thread.sleep(5000);
	     
		  PropertyLoader pl = new PropertyLoader();
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		
		
		driver.findElement(By.xpath("//a[@class='listRelatedObject accountBlock title']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		
		waitElementToVisibleLocated(By.xpath("//input[@name='new']"));
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='ext-gen148']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
//		driver.findElement(By.xpath("//img[@id='ext-gen152']")).click();
//		driver.findElement(By.id("ext-gen279")).click();
//		driver.findElement(By.xpath("//img[@id='ext-gen154']")).click();
//		driver.findElement(By.id("ext-gen299")).click();
		driver.findElement(By.xpath("//input[@id='ext-comp-1042']")).sendKeys("04/25/2020");
		driver.findElement(By.xpath("//input[@id='ext-comp-1045']")).clear();
		driver.findElement(By.xpath("//input[@id='ext-comp-1045']")).sendKeys("04/25/2020");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='ext-gen49']")).click();
		driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']")).sendKeys("bb");
		driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).sendKeys("g");
		//driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//button[@id='ext-gen63']")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
			
	}
	
	
		

	public static void main(String[] args) throws Exception {
		
		newView();
		editNewView();
		createanAccount();
	    mergeAccounts();
		accountReport();
		
	}

}
