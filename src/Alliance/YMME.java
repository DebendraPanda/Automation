package Alliance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YMME {
	public static void main(String [] args) throws Exception {
WebDriver driver =new ChromeDriver() ;
driver.manage().window().maximize();
driver.navigate().to("https://staging.allianceconnect.com/web/sandbox/home");	
if(driver.getTitle().equals("Alliance HQ Sandbox")) {
	System.out.println("Title Matched");
}
else {
	System.out.println("Title not matched and expected is "+driver.getTitle());
}
Thread.sleep(3000);	

//Login 
driver.findElement(By.xpath("(//*[@id='sign-in'])[3]")).click();
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("dptestuser1");
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
Thread.sleep(7000);		
System.out.println("Login Successfully");

// Navigate to shop side
driver.findElement(By.xpath("(//*[@class='pnl-icon icon-2x icon-globe'])[1]")).click();
driver.findElement(By.xpath("(//*[@class='dropdown-item sitesNameDropdownItem '])[4]")).click();
Thread.sleep(9000);

//Year
driver.findElement(By.xpath("//*[@title='2010']")).click();
Thread.sleep(4000);

//Make
driver.findElement(By.xpath("//*[@title='AUDI']")).click();
Thread.sleep(1000);

//Model
driver.findElement(By.xpath("//*[@title='A3']")).click();
Thread.sleep(1000);

//Engine
driver.findElement(By.xpath("//*[@title='All Engine']")).click();
Thread.sleep(1000);

//Categories
driver.findElement(By.xpath("//*[@title='Belts & Cooling']")).click();
Thread.sleep(1000);

//Group
driver.findElement(By.xpath("//*[@title='Belts']")).click();
Thread.sleep(3000);

//Select a Engine
driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();
Thread.sleep(2000);

// Click on Go button
driver.findElement(By.xpath("(//*[@class='go_btn'])[1]")).click();
Thread.sleep(2000);

//select radio button from Yes/No/Don't Know
driver.findElement(By.xpath("(//*[@id='name_0'])[1]")).click();
Thread.sleep(2000);

//Click on go button
driver.findElement(By.xpath("(//*[@id='cgs_go3'])[1]")).click();
Thread.sleep(3000);
System.out.println("Results are displaying");

//Adding Part into the cart
driver.findElement(By.xpath("(//*[@class='add2cart'])[1]")).click();
Thread.sleep(2000);

//Click on Checkout button
driver.findElement(By.xpath("(//*[text()='Checkout'])[1]")).click();
Thread.sleep(3000);
System.out.println("Parts added in to the cart");
driver.close();
}
}
