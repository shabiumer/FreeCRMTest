package qa.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

import org.openqa.selenium.WebDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListner eventlistner;
	public static EventFiringWebDriver e_driver;
	
		public TestBase() {
			
			
			prop =  new Properties(); 	 
	
			FileInputStream ip;
			try {
				ip = new FileInputStream("C:\\Users\\User\\Documents\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\"
						+ "crm\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	
	
	
	}
		
	public static void initialization() {
		String browserName = prop.getProperty("browser");	
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\JavaforTesters\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\Documents\\JavaforTesters\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
	}
		else if (browserName.equals("edge")) {
			System.getProperty("webdriver.edge.driver", "C:\\Users\\User\\Documents\\JavaforTesters\\WebDrivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();	
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistner = new WebEventListner();
		e_driver.register(eventlistner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitlyWait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("Url"));
}
}