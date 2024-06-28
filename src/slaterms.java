package SlaTerms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class slaterms {

public static void main(String [] args) throws Exception {
System.setProperty("webdriver.chrome.driver","C:/Users/deben/Downloads/chromedriver-win64/chromedriver.exe/");
WebDriver driver =new ChromeDriver() ;
//driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

driver.manage().window().maximize();
	driver.navigate().to("https://staging.allianceconnect.com/web/sandbox/home");
	
//Login to sandbox site
		driver.findElement(By.id("sign-in")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("aa000adminhq");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("s0lut10n!");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(6000);
		
//Navigate to SLATerms Module	
		driver.findElement(By.xpath("(//span[@class='pnl-icon icon-2x icon-globe'])[1]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[text()='Sandbox'])[2]")).click();
		Thread.sleep(6000);
		WebElement menuElement = driver.findElement(By.xpath("(//span[@class='text-truncate'])[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menuElement).perform();
		driver.findElement(By.xpath("//a[text()='DeliverBy/Consolidate']")).click();
		Thread.sleep(6000);
		
//To Create Schedule
		driver.findElement(By.xpath("(//i[@class='mdi mdi-plus'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='text'][@maxlength='40'])[1]")).sendKeys("DebendraTesting");
		driver.findElement(By.xpath("//span[text()=' Save ']")).click();
		System.out.println("Record Saved Successfully");
		Thread.sleep(9000);
		
//Add Above Records for Scedule	
		driver.findElement(By.xpath("//option[text()=' DebendraTesting ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Add new Above']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'][@maxlength='40'])[2]")).sendKeys("Location");
		
		//Select Min
		Select minsDropdown = new Select(driver.findElement(By.id("selectedMinute")));
		minsDropdown.selectByValue("15");
		Thread.sleep(5000);
		
		//Select AM/PM
		Select ampmDropdown = new Select(driver.findElement(By.xpath("(//select[starts-with(@class,'form-control')])[4]")));
		ampmDropdown.selectByVisibleText("PM");
		Thread.sleep(5000);
		
//1-Select One Day Checkbox
//		driver.findElement(By.xpath("//label[text()='Weekdays']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
//		Thread.sleep(4000);	
//		driver.findElement(By.xpath("//span[text()='OK']")).click();
//		Thread.sleep(2000);

////2-Select all the Checkbox
//		List<WebElement> checkboxes =driver.findElements(By.xpath("//label[@class='week-days-label' and contains(@for,'day')]"));
//		int size=checkboxes.size();
//		System.out.println("Total No of checkboxes:"+size);
		
//		//using for loop
//		for (int i=0; i<size; i++)
//		{
//			checkboxes.get(i).click();
//		}
		
//		//using for each loop
//		for(WebElement chbox:checkboxes)
//		{
//			chbox.click();
//		}
		
////3- Select Multiple checkbox by choice
//		List<WebElement> checkboxes =driver.findElements(By.xpath("//label[@class='week-days-label' and contains(@for,'day')]"));
//		int size=checkboxes.size();
//		System.out.println("Total No of checkboxes:"+size);
//	    for(WebElement chbox:checkboxes)
//	    {
//	    	String checkboxname=chbox.getAttribute("for");
//	    	if (checkboxname.equals("monday")||checkboxname.equals("tuesday")) 
//	    	{
//	    		chbox.click();
//	    	}
//	    }
		
////4- Select Last 2 checkbox 
//				List<WebElement> checkboxes =driver.findElements(By.xpath("//label[@class='week-days-label' and contains(@for,'day')]"));
//				int totalnoofchbox =checkboxes.size();
//				System.out.println("Total No of checkboxes:"+totalnoofchbox);
//			    for(int i=totalnoofchbox-2;i<totalnoofchbox;i++)
//			    {
//			    	checkboxes.get(i).click();
//
//			    }
		
//5- Select first 2 checkbox 
		List<WebElement> checkboxes =driver.findElements(By.xpath("//label[@class='week-days-label' and contains(@for,'day')]"));
		int totalnoofchbox =checkboxes.size();
		System.out.println("Total No of checkboxes:"+totalnoofchbox);
	    for(int i=0;i<totalnoofchbox;i++)
	    {
	    	if(i<3) 
	    	{
		    	checkboxes.get(i).click();

	    	}

	    }
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		Thread.sleep(4000);	
		driver.findElement(By.xpath("//span[text()='OK']")).click();
		Thread.sleep(6000);
		
//Add Below Records for Scedule	
				driver.findElement(By.xpath("//button[@title='Add new Below']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='text'][@maxlength='40'])[2]")).sendKeys("Testing");
				
				//Select Minute
				Select minsDropdown1 = new Select(driver.findElement(By.id("selectedMinute")));
				minsDropdown1.selectByValue("30");
				Thread.sleep(5000);
				
				//Select AM/PM
				Select ampmDropdown1 = new Select(driver.findElement(By.xpath("(//select[starts-with(@class,'form-control')])[4]")));
				ampmDropdown1.selectByVisibleText("AM");
				Thread.sleep(5000);	
				
				//Select Weekdays
				driver.findElement(By.xpath("//label[text()='Weekdays']")).click();
				Thread.sleep(2000);
				
				//Save functionality
				driver.findElement(By.xpath("//button[text()=' Save ']")).click();
				Thread.sleep(4000);	
				driver.findElement(By.xpath("//span[text()='OK']")).click();
				Thread.sleep(2000);
	
//To Delete Schedule		
		driver.findElement(By.xpath("//option[text()=' DebendraTesting ']")).click();
		Thread.sleep(4000);
	    driver.findElement(By.xpath("/html/body/div[5]/div[2]/section/div/div/div/div/div[2]/section/div/div[2]/div/div/div/section/div/div/div/div/div[1]/div[1]/div/div[2]/button[2]/span[1]/i")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//span[text()='OK']")).click();
		System.out.println("Record Deleted Successfully");	
		Thread.sleep(5000);
//To close browser
		driver.close();
}

}