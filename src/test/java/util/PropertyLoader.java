package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertyLoader {
	
	Properties prop = new Properties();	
	
	public static void main(String[] args) throws URISyntaxException {
		PropertyLoader pl = new PropertyLoader();
		System.out.println(pl.locateFilePath("accessmodifier.png"));
	}

	
	public PropertyLoader(){
		
		loadProperties();
	}
	
	public void loadProperties() {
		
		
		try {
		
		InputStream fi = this.getClass().getResourceAsStream("/Salesforce.properties");
		prop.load(fi);
		//System.getProperties().putAll(prop);
		//System.out.println("Property value of Username = "+prop.getProperty("Username"));
		//System.out.println("Property value of Password = "+System.getProperty("Password"));
		
		}catch(Exception a) {
			System.out.println(a);
		}
		
	}
	
	public String locateFilePath(String fileName) throws URISyntaxException {
		URL url = this.getClass().getClassLoader().getResource(fileName);
		URI uri = url.toURI();
		File file = new File(uri);
		String path = file.getAbsolutePath();
		
		return path;
		
	}
	
	//driver.findElement(By.xpath("//input[@id='un']")).sendKeys(pl.locateFilePath(pl.getProperty("File")));

	
	public String getProperty(String key) {
		
		return prop.getProperty(key);
	}

}
