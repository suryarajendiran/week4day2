package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://www.nykaa.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
	Actions action = new Actions(driver);
	action.moveToElement(brand).perform();
	driver.findElement(By.xpath("//input[@placeholder='search brands']")).sendKeys("L'Oreal Paris");
	driver.findElement(By.xpath("(//a[contains(@href,'/brands/loreal-paris/c/')])[1]")).click();
	String name=driver.getTitle();
	if(name.contains("Paris")) {
		System.out.println("Title name contains Paris");
	}
	else
	{
		System.out.println("Title name does not contains Paris");
	}
	 driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
	 driver.findElement(By.xpath("//span[contains(text(),'top rated')]")).click();
	 driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
	 driver.findElement(By.xpath("(//span[contains(text(),'Hair')])[1]")).click();
	 driver.findElement(By.xpath("//span[contains(text(),'Hair Care')]")).click();
	 driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
	 driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();
	 driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();
	String txt= driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).getText();
	if(txt.contains("Shampoo")) {
		System.out.println("It contains Shampoo");
	}
	else
	{
		System.out.println("It does not Contains shmapoo");
	}
	driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')] ")).click();
	Set<String> WindowSize=driver.getWindowHandles();
	List<String> WindowList=new ArrayList<String>(WindowSize);
	String txt1=driver.findElement(By.xpath("(//span[contains(text(),'MRP:')])")).getText();
	driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
	driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		String price = driver.findElement(By.xpath("//span[text()='Grand Total']")).getText();
		System.out.println("Grand Price : "+price);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	driver.findElement(By.xpath("(//img[@alt='Image'])[7]")).click();
		String amt = driver.findElement(By.xpath("(//p[text()='₹391']")).getText();
	
	if(price.contains(amt)) {
		System.out.println(amt);
	}
	else{
		System.out.println("Amount not Match");
	}
	
	driver.quit();
	
	
	}

}
