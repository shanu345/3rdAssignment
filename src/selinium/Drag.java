package selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag {

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
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");    		
    WebElement From=driver.findElement(By.xpath("//div[@id='column-a']"));	
     		
     WebElement To=driver.findElement(By.xpath("//div[@id='column-b']"));					
  		
     Actions act=new Actions(driver);					
		
     act.dragAndDrop(From, To).build().perform();

	}

}
