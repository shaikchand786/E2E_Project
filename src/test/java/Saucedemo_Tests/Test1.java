package Saucedemo_Tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	@Test
	public static void E2E_Application() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		//Login Page
		WebElement UN = driver.findElement(By.xpath("//div[@id='login_credentials']"));
		String allText = UN.getText();
		String userName="";
		String[] probUsers = allText.split("\\r?\n");
		for(String probUser : probUsers) {
			if(probUser.trim().equalsIgnoreCase("standard_user")) {
				userName = probUser;
			}
		}
		driver.findElement(By.id("user-name")).sendKeys(userName);
		
		WebElement PW = driver.findElement(By.xpath("//div[@class='login_password']"));
		String allPW = PW.getText();
		String passWord="";
		String[] probPWs = allPW.split("\\r?\n");
		for(String probPW : probPWs) {
			if(probPW.trim().equalsIgnoreCase("secret_sauce")) {
				passWord = probPW;
			}
		}
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
		driver.findElement(By.id("login-button")).click();
		
		//Dashboard Page
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		Thread.sleep(2000);
		
		//Cart Page
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("abc");
		driver.findElement(By.id("last-name")).sendKeys("xyz");
		driver.findElement(By.id("postal-code")).sendKeys("500035");
		driver.findElement(By.id("continue")).click();
		
		//Checkout Page
		WebElement price = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
		Thread.sleep(2000);
		String TotalPrice = price.getText();
		System.out.println(TotalPrice);
		driver.findElement(By.id("finish")).click();
		
		
		driver.close();
	}
}
