package utils;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
public static WebDriver getDriver() throws Exception {
	
	WebDriver driver = null;

	InputStream input = Driver.class.getClassLoader().getResourceAsStream("input.properties");
	Properties prop =  new Properties();
	prop.load(input);
	String driver_path = prop.getProperty("webdriverpath");
	String browser = prop.getProperty("browser");

	if (browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", driver_path);
		driver = new ChromeDriver();
	}
	else if (browser.equals("firefox")) {
		System.setProperty("webdriver.getco.driver", driver_path);
		driver = new FirefoxDriver();
	} else {
		
	}
	return driver;
}
}
