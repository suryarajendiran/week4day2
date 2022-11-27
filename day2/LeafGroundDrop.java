package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.leafground.com/drag.xhtml");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				Actions build = new Actions(driver);
				WebElement a = driver.findElement(By.xpath("//p[text()='Drag to target']"));
				build.dragAndDropBy(a,100,75).perform();	
				System.out.println("Element Droped");
				driver.close();
	}

}
