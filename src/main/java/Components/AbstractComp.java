package Components;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComp {
	
WebDriver driver;
	
	public AbstractComp(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	public void WaitForElementToAppear(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 	wait.until(ExpectedConditions.visibilityOf(element));
	}


}
