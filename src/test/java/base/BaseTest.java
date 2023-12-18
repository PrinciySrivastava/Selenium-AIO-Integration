package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileReader;
import java.util.Properties;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader f1;

	@BeforeTest (groups = {"OPAA-TC-224", "OPAA-TC-225", "OPAA-TC-226", "OPAA-TC-227", "OPAA-TC-228", "OPAA-TC-240", "OPAA-TC-241"})
	public void setUp() throws Exception {
		if (driver == null) {
			f1 = new FileReader(System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
			prop.load(f1);
		}

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));
		}

		else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver();
			driver.get(prop.getProperty("URL"));

		}

		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	@AfterTest(groups = {"OPAA-TC-224", "OPAA-TC-225", "OPAA-TC-226", "OPAA-TC-227", "OPAA-TC-228", "OPAA-TC-240", "OPAA-TC-241"})
	public void tearDown() throws Exception {
	driver.quit();
	}

	
}