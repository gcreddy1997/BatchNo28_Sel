package GeneralCode;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralCode {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver1//chromedriver.exe");
		WebDriver driver = new ChromeDriver();                  // dynamic dispatch method
		// maximize the window
		driver.manage().window().maximize();
				// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//*[text()='Sign In / Join AJIO']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='google-login']")).click();
		Thread.sleep(1000);
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));		
		driver.navigate().to("https://accounts.google.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("gcreddy1997@gmail.com");
		

	}

}
