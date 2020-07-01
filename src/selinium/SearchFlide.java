package selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchFlide {

	public static void main(String[] args) {
		WebDriver driver = null;
		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("one chose any browser");
		}
		driver.get(" https://www.cleartrip.com/");
		driver.findElement(By.id("FromTag")).sendKeys("mumbai");
		driver.findElement(By.id("ToTag")).sendKeys("pune");
		driver.findElement(By.id("DepartDate")).sendKeys("25/8/2020");
		Select s = new Select(driver.findElement(By.name("childs")));
		s.selectByVisibleText("4");
		Select b = new Select(driver.findElement(By.name("infants")));
		b.selectByVisibleText("1");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.xpath("(//strong[@class='resultsCount'])[1]")).getText());
		driver.quit();
	}

}
