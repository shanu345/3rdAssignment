package script;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Utility;

public class Script {

	public static void main(String[] args) {
		Utility.getDriver();
		//WebElement ele = driver.findElement( By.xpath("//frame[@name='frame-bottom']"));
		//driver.switchTo().frame(ele);
		Utility.print();	
		Utility.sizeOfFrame();
		Utility.end();
	}

}
