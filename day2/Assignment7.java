package week4.day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebElement men = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Men']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(men).perform();
		driver.findElement(By.xpath("//li[@data-reactid='40']")).click();
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText().replaceAll("[^0-9]", "");
		System.out.println("Total Count : "+count);
		String data = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText().replaceAll("[^0-9]", "");
		int i=Integer.parseInt(data); 
		String data1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText().replaceAll("[^0-9]", "");
		int j=Integer.parseInt(data1);
		int k = i+j;
		String res = Integer.toString(j);
				if(count.contains(res)) {
			System.out.println("Iteam of count is Match");
		}
		else {
			System.out.println("Iteam of count is not Match");
		}
		driver.findElement(By.xpath("//label[text()='Jackets']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//label[text()='Duke']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close sprites-remove')]")).click();
		List<WebElement> name = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		System.out.println(name.size());
		for(int a=0; a<name.size(); a++) {
			if(!name.get(a).getText().contains("Duke")) {
				System.out.println("NOt matched");
			}
			else {
				System.out.println("Matched");
			}
		}
		System.out.println("The name of the brand is Duke");
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions sh = new Actions(driver);
		sh.moveToElement(sort).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
		Set<String> WH = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(WH);
		driver.switchTo().window(lst.get(1));
		File data11 = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File data2 = new File("./snap/screen.png");
		FileUtils.copyFile(data11, data2);
				driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
	
		driver.close();
		
	}

}
