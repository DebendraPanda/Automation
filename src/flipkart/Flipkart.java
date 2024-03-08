package flipkart;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Flipkart {
public static void main(String [] args)throws Exception {
	
// Flipkart.com
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://www.flipkart.com/");
	
	driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8984691948");
	driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("bapina@123");
driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Mi Note 10 Pro");
driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]")).click();
Thread.sleep(2000);
String parentHandle=driver.getWindowHandle();
System.out.println("parent window - "+parentHandle);
Set<String> handles = driver.getWindowHandles();
for(String handle : handles) {
	System.out.println(handle);
if(!handle.equals(parentHandle)) {
	driver.switchTo().window(handle);
	driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[@class='_3dsJAO'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='_3dsJAO _24d-qY FhkMJZ']")).click();
	Thread.sleep(2000);
	driver.close();
	driver.switchTo().window(parentHandle);
	Thread.sleep(2000);
}
}
WebElement element=driver.findElement(By.xpath("//div[text()='Debendra']"));
Actions action=new Actions(driver);
action.moveToElement(element).build().perform();
driver.findElement(By.xpath("//div[text()='Logout']")).click();
Thread.sleep(2000);
driver.close();

//Youtube.com

WebDriver driver1=new ChromeDriver();
driver1.manage().window().maximize();
driver1.navigate().to("https://www.youtube.com/");
Thread.sleep(2000);
driver1.findElement(By.xpath("//input[@id='search']")).sendKeys("Cucumber Framework");
/*
 * Thread.sleep(2000);
 * driver1.findElement(By.xpath("(//button[@aria-label='Search'])[2]")).click();
 * Thread.sleep(2000);
 */
driver1.quit();

//Redmine.com

WebDriver driver2=new ChromeDriver();
driver2.manage().window().maximize();
driver2.navigate().to("https://redmine.cognitivzen.com/login");


if(driver2.getTitle().equals("Redmine")) 
{
	System.out.println("Title Matched");
}
else 
{
	System.out.println("Title not matched and expected is "+driver2.getTitle());
}
driver2.findElement(By.id("username")).sendKeys("debendra.panda");
driver2.findElement(By.id("password")).sendKeys("Bapina@123");
Thread.sleep(2000);
driver2.findElement(By.name("login")).click();
Thread.sleep(4000);
System.out.println("Login Successfully");
Thread.sleep(3000);
driver2.findElement(By.xpath("//span[@class='drdn-trigger']")).click();
driver2.findElement(By.xpath("(//span[text()='Testing Freshers Training'])[1]")).click();
Thread.sleep(2000);
driver2.findElement(By.xpath("//a[@class='issues']")).click();
Thread.sleep(2000);
driver2.findElement(By.xpath("(//a[text()='New issue'])[2]")).click();
driver2.findElement(By.className("logout")).click();
System.out.println("Logout Successfully");
driver2.close();
}
}


