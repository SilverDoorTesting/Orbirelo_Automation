package SilverDoor.Orbirelo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static PropertiesConfiguration propConfig;

	public static String CURRENT_DIR = System.getProperty("user.dir");
	public String PROPERTIES_FILE_PATH = CURRENT_DIR + "\\src\\main\\java\\SilverDoor\\Orbirelo\\qa\\config\\config.properties";

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(PROPERTIES_FILE_PATH);
			prop.load(ip);
			propConfig = new PropertiesConfiguration(PROPERTIES_FILE_PATH);

		} catch (IOException | ConfigurationException e) {
			e.printStackTrace();
		} 
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory",
					System.getProperty("user.dir") + File.separator + "file_downloads");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\silverdoo\\eclipse-workspace\\drivers\\chrome\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Browser not found");
		}

		driver.manage().window().maximize();
		String username = prop.getProperty("username1");
		String password = prop.getProperty("password1");
		String url = prop.getProperty("url");


		try {  
			username = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());
			password = URLEncoder.encode(password, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String page_url = "https://" + username + ":" + password + "@" + url;
		driver.get(page_url);

		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



}

