package samplejava;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CognitivZen {
	
public static void main(String [] args) throws Exception {
	WebDriver driver =new ChromeDriver() ;
	driver.manage().window().maximize();
	driver.navigate().to("http://intranet.cognitivzen.com.s3-website.ap-south-1.amazonaws.com/login");
	if(driver.getTitle().equals("CognitivZen Technologies")) {
		System.out.println("Title Matched");
	}
	else {
		System.out.println("Title not matched and expected is "+driver.getTitle());
	}
	Thread.sleep(4000);
	String parentHandle=driver.getWindowHandle();
	System.out.println("parent window - "+parentHandle);
	driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/button")).click();
Set<String> handles = driver.getWindowHandles();
	for(String handle : handles) {
		System.out.println(handle);
	if(!handle.equals(parentHandle)) {
		driver.switchTo().window(handle);
		Robot r=new Robot();
	driver.findElement(By.id("identifierId")).sendKeys("debendra.panda@cognitivzen.com");
r.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Bapina@123");
	r.keyPress(KeyEvent.VK_ENTER);
	System.out.println("Login Successfully");
	Thread.sleep(2000);
	driver.switchTo().window(parentHandle);

	}
	}
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
	driver.findElement(By.name("FolderName")).sendKeys("D4");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-vab9qx'])[2]")).click();
	System.out.println("New Folder Created Successfully");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-vab9qx']")).click();
	Robot r1= new Robot();
	r1.delay(2000);
	StringSelection s=new StringSelection("C:\\Users\\deben\\Downloads\\Waits in Selenium  (1) (3).docx");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	r1.keyRelease(KeyEvent.VK_CONTROL);
	r1.keyRelease(KeyEvent.VK_V);
	
	r1.keyPress(KeyEvent.VK_CONTROL);
	r1.keyPress(KeyEvent.VK_V);
	 r1.keyPress(KeyEvent.VK_ENTER);
	 r1.keyRelease(KeyEvent.VK_ENTER);
	 Thread.sleep(3000);
	 System.out.println("Upload Successfully");
	 driver.findElement(By.xpath("(//span[text()='more_vert'])[3]")).click();
	 Thread.sleep(2000);
	driver.findElement(By.xpath("(//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-7e2t4u'])[2]")).click();
	Thread.sleep(2000); 
	System.out.println("Dowload Successfully");
	driver.findElement(By.xpath("(//img[@alt='Debendra Panda'])[2]")).click(); 
	driver.findElement(By.xpath("//li[@class='MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root css-7e2t4u']")).click();
	System.out.println("Logout Successfully");
	Thread.sleep(3000);
	driver.close();
}
	}





