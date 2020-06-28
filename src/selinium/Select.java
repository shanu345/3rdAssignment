package selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Select {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("one chose any browser");
		}
		driver.get(" https://rahulshettyacademy.com/AutomationPractice/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());  
	    System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());
	    Thread.sleep(10000);
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());

	}
	
}
