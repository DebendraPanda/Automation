package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PermissionPopupNotification {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver","C:/Users/deben/Downloads/chromedriver-win64/chromedriver.exe/");
		WebDriver driver =new ChromeDriver(options) ;
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.redbus.in/");
		
	}

}
