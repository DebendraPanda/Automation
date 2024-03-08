package Practice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
	
		public static void main(String[] args)throws Exception {
			
				System.setProperty("webdriver.chrome.driver","C:/Users/deben/Downloads/chromedriver-win64/chromedriver.exe/");
				WebDriver driver =new ChromeDriver() ;
				driver.manage().window().maximize();
				
				driver.navigate().to("https://www.amazon.in/");
				
//				String title=driver.getTitle();
//				System.out.println(title);
//				Thread.sleep(2000);
//				driver.findElement(By.linkText("Today's Deals")).click();
//			//	driver.findElement(By.partialLinkText("Deals")).click();
//				
//				String title1=driver.getTitle();
//				System.out.println(title1);
				
				//How to capture all the links
			    List<WebElement> links=driver.findElements(By.tagName("a"));
			   // System.out.println("Number of links present:" +links.size());
			    
			    //for loop
//			    for(int i=0;i<=links.size();i++)
//			    {
//			    	System.out.println("Link Text: "+ links.get(i).getText());
//			    	System.out.println("Name of the link: "+ links.get(i).getAttribute("href"));
//			    }
//			    	
			    //For each loop
			    
			    for(WebElement link:links) 
			    {
			    	System.out.println("Link Text: "+ link.getText());
			    	System.out.println("Name of the link: "+ link.getAttribute("href"));
			    	
			    }
			    
			    
		driver.close();	    
}
		
}
