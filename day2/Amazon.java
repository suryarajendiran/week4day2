package week4.day2;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
        String txt=driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        System.out.println(txt);
        txt = txt.replaceAll("[^a-zA-Z0-9]", "");
        driver.findElement(By.xpath("(//span[text()='Customer Review'])[1]")).click();
        String rateing=driver.findElement(By.xpath("(//span[text()='387'])[1]")).getText();
        System.out.println(rateing);
        	driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        	Set<String> window=driver.getWindowHandles();
        	List<String> phone=new ArrayList<String>(window);
        	driver.switchTo().window(phone.get(1));
        	File  a = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
    		//File a = driver.getScreenshotAs(OutputType.FILE);
    	    File b =new File("./snap/frame.png");
    		FileUtils.copyFile(a, b);
    		    		driver.findElement(By.id("add-to-cart-button")).click();
    		Thread.sleep(8000);
    		String grandTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText().replaceAll("[^0-9]", "").substring(0, 5);
    		if(txt.contains(grandTotal)) {
    			System.out.println(grandTotal);
    		}
    		else {
    			System.out.println(" Price is Not Same");
    		}
    		driver.close();

	}

}
