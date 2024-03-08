package samplejava;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redmine {
	public static void main(String [] args) throws InterruptedException{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
		driver.navigate().to("https://redmine.cognitivzen.com/login");
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("Redmine")) 
		{
			System.out.println("Title Matched");
		}
		else 
		{
			System.out.println("Title not matched and expected is "+driver.getTitle());
		}
		driver.findElement(By.id("username")).sendKeys("debendra.panda");
		driver.findElement(By.id("password")).sendKeys("Bapina@123");
	driver.findElement(By.name("login")).click();
	Thread.sleep(4000);
	System.out.println("Login Successfully");
	driver.findElement(By.className("my-account")).click();
	System.out.println("My Account page Opened");
	Thread.sleep(4000);
	driver.findElement(By.linkText("debendra.panda")).click();
	System.out.println("Debendra Panda Recent Activity and Project Showing");
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/table[2]/tbody/tr/td[1]/span/a")).click();
	System.out.println("Overview Page Opened");
	Thread.sleep(3000);
	driver.findElement(By.className("logout")).click();
	Thread.sleep(3000);
	System.out.println("Logout Successfully");
		driver.close();
	}
	
	}



