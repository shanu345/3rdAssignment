package utility;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {
	public static JavascriptExecutor js = null;
	public static WebDriver driver = null;
	public static String browser = null;
	public static String URL = null;
	public static int timeLimit = 0;
	public static String mainDir = System.getProperty("user.dir");
	
	static{
		try {
			FileInputStream fs = new FileInputStream(mainDir + "\\src\\config.properties");
			Properties prop = new Properties();
			prop.load(fs);
			browser = prop.getProperty("browser");
			URL = prop.getProperty("URL");
			timeLimit = Integer.parseInt(prop.getProperty("timeLimit"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static WebDriver getDriver() {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", mainDir + "\\resource\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("fireFox")) {
			System.setProperty("webdriver.gecko.driver", mainDir + "\\resource\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeLimit, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;
	}
	public static void print() {
//	driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));//print for single frame use for name tag
//	System.out.println(driver.findElement(By.xpath("//body")).getText());
		List<WebElement> innerFrames = null;// print for multiple frame use name tag
		List<WebElement> frames = null;
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[1]")));
		innerFrames = driver.findElements(By.xpath("//frame"));
		
		for(WebElement innerElem:innerFrames) {
			driver.switchTo().frame(innerElem);
			System.out.println(driver.findElement(By.xpath("//body")).getText());
			driver.switchTo().parentFrame();
		}
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[2]")));
		System.out.println(driver.findElement(By.xpath("//body")).getText());

	}
	public static void sizeOfFrame() {
		int size = driver.findElements(By.tagName("frameset")).size();
		System.out.println("Total Frames --" + size);
	}
	public static void end() {
		driver.quit();
	}
}
