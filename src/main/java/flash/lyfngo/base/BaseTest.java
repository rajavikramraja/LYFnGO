package flash.lyfngo.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import flash.lyfngo.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 protected WebDriver driver;
	    protected Properties prop;

	    @BeforeMethod
	    public void setup() {
	        // Load properties
	    	
	        prop = ConfigReader.initProperties();
	        String browser = prop.getProperty("browser").toLowerCase();
	        String urlLyf = prop.getProperty("urlLyf");

	        // Launch browser based on config
	        switch (browser) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                break;
	            case "edge":
	            	try {
	            		 WebDriverManager.edgedriver().setup();
	                     driver = new EdgeDriver();	
					} catch (Exception e) {
						System.setProperty("webdriver.edge.driver", "C:\\Users\\vikra\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			                driver = new EdgeDriver();
						// TODO: handle exception
					}
	               
	                break;
	            default:
	                throw new RuntimeException("Browser not supported: " + browser);
	        }

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get(urlLyf);
	    }

	    @AfterMethod
	    public void closeEntireWindow() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
