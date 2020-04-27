package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.PropertyLoader;

public class CreateOpty extends SFReuseMethods{
	
	static void optDropDown() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		
		
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject opportunityBlock title')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		
		waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
		driver.findElement(By.xpath("//select[@id='fcf']")).click();
		
	Thread.sleep(5000);
	driver.quit();
		
}
	
	static void createNewOpty() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject opportunityBlock title')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		
		waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
		driver.findElement(By.xpath("//input[@name='new']")).click();
		
		driver.findElement(By.xpath("//input[@id='opp3']")).sendKeys("newopt");
		driver.findElement(By.xpath("//a[contains(text(),'4/25/2020')]")).click();
		
		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		stage.click();
		Select s = new Select(stage);
		s.selectByIndex(3);
		
		WebElement ls = driver.findElement(By.xpath("//select[@id='opp6']"));
		ls.click();
		Select l = new Select(ls);
		l.selectByIndex(2);
		driver.findElement(By.xpath("//input[@id='opp12']")).clear();
		driver.findElement(By.xpath("//input[@id='opp12']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@id='opp4']")).sendKeys("sre");
		driver.findElement(By.xpath("//input[@id='opp17']")).sendKeys("camp");
		driver.findElement(By.xpath("//div[contains(@class,'pbHeader')]//input[1]")).click();
		
		
		
	Thread.sleep(5000);
	driver.quit();
		
}
	
	static void optPipelineReport() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject opportunityBlock title')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
			
	}
		
	static void stuckOptReport() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject opportunityBlock title')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
			
	}
		
	static void quaterlySumReport() throws Exception {
	     loginToSF();
	     Thread.sleep(3000);
	     
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@class,'listRelatedObject opportunityBlock title')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tryLexDialogX")).click();
		
		waitElementToVisibleLocated(By.xpath("//select[@id='fcf']"));
		
		WebElement interval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		interval.click();
		Select cy = new Select(interval);
		cy.selectByIndex(5);
		
		WebElement include = driver.findElement(By.xpath("//select[@id='open']"));
		include.click();
		Select op = new Select(include);
		op.selectByIndex(1);
		
		driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']")).click();
		
		String expected = "Opportunity Report";
		
      String actual = driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		
		if(actual.equals(expected)) {
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		
		
		Thread.sleep(5000);
		driver.quit();
			
	}
		
		
	

	public static void main(String[] args) throws Exception {
		
		optDropDown(); 
		createNewOpty();
		optPipelineReport();
		stuckOptReport();
		quaterlySumReport();
		
	}

}
