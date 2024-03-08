package Practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C:/Users/deben/Downloads/chromedriver-win64/chromedriver.exe/");
		WebDriver driver =new ChromeDriver() ;
		driver.manage().window().maximize();
		
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> Links=driver.findElements(By.tagName("a"));
		
		   int brokenLinks=0; 
		
		for(WebElement element:Links)
		{
			String url=element.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is Empty");
				continue;
			}
			URL link = new URL(url);
			try{
				HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				httpconn.connect();
				if(httpconn.getResponseCode()>=400)
				{
					System.out.println(httpconn.getResponseCode()+url+"  is"+"   Broken link");
					brokenLinks++;
				}
				else
				{
					System.out.println(httpconn.getResponseCode()+url+"  is"+"   Valid link");

				}
				
			}catch(Exception e) {
			
			}
		
		}
		System.out.println("Number of broken links: "+ brokenLinks);
		driver.quit();
	}

}
