package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) 		throws Exception {
		
			System.setProperty("webdriver.chrome.driver","C:/Users/deben/Downloads/chromedriver-win64/chromedriver.exe/");
			WebDriver driver =new ChromeDriver() ;
			//driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

			driver.manage().window().maximize();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(3000);
//getWindowHandle()
//			String windowId=driver.getWindowHandle();
//			System.out.println(windowId);
			
			
//getWindowHandles()
			driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
			Set<String> windowIds=driver.getWindowHandles();
			
			//Using List/ArrayList
			List<String> windowIdsList= new ArrayList(windowIds);
//		    String parentWindowId=windowIdsList.get(0);
//		    String childWindowId=windowIdsList.get(1);
//
//			System.out.println("Parent Window Id: " +parentWindowId);
//			System.out.println("Child Window Id: " +childWindowId);
//			
//			
//			//How to use window ID's for switching
//			
//			driver.switchTo().window(parentWindowId);
//			System.out.println("Parent window title:"+ driver.getTitle());
//			
//			driver.switchTo().window(childWindowId);
//			System.out.println("Child window title:"+ driver.getTitle());
			
			//For each loop to print window Id's ,Windowtitle and close the window based on the choice
			for(String winid:windowIdsList)
			{
				System.out.println(winid);
				String title=driver.switchTo().window(winid).getTitle();
				System.out.println(title);
				if(title.equals("OrangeHRM HR Software | OrangeHRM"))
				{
					driver.close();
				}
			}
	}

} 
