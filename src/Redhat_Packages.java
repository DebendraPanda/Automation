import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Redhat_Packages {

	
	public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();     	
  		driver.navigate().to("https://access.redhat.com/downloads/content/package-browser");
  		driver.findElement(By.id("username-verification")).sendKeys("vvenna.czn");
  		driver.findElement(By.id("login-show-step2")).click();
  		Thread.sleep(2000);
  		driver.findElement(By.id("password")).sendKeys("Abcdef@2024");
  		driver.findElement(By.id("rh-password-verification-submit-button")).click();
  		Thread.sleep(9000);
  		
  		driver.findElement(By.xpath("//a[@href='/downloads/content/389-ds-base/aarch64/package-latest']")).click();
  		Thread.sleep(4000);
  		WebElement versions=driver.findElement(By.xpath("//select[@id='evr' and @class='select-chosen linked']"));
  		
  		
  		((RemoteWebDriver) driver).executeScript("arguments[0].style.display='block';", versions);
  		Select dropdown=new Select(versions);
  		
  		 List<WebElement> allOptions = dropdown.getOptions();
  		  List<String> dropdownValues = new ArrayList<>();
          for (WebElement option : allOptions) {
              dropdownValues.add(option.getText());
          }


          Workbook workbook = new XSSFWorkbook();
          Sheet sheet = workbook.createSheet("Download Links");

          int rowCount = 0;
          
          for (String value : dropdownValues) {
              versions = driver.findElement(By.xpath("//select[@id='evr' and @class='select-chosen linked']")); // Re-locate the dropdown element
              ((RemoteWebDriver) driver).executeScript("arguments[0].style.display='block';", versions);
              dropdown = new Select(versions);
              dropdown.selectByVisibleText(value);
              Thread.sleep(8000);
              
              List<WebElement> links = driver.findElements(By.tagName("a"));
              int columnCount = 0;
              Row row = sheet.createRow(rowCount++); // Create a new row for each set of links
              for (WebElement link : links) {
                  String href = link.getAttribute("href");
                  if (href != null && href.contains("access.cdn.redhat.com/content/origin/rpms")) {
                      Cell cell = row.createCell(columnCount++);
                      cell.setCellValue(href);
                      if (columnCount == 2) {
                          columnCount = 0;
                          row = sheet.createRow(rowCount++);
                      }
                  }
              }
          }

              try (FileOutputStream fileOut = new FileOutputStream("download_links_2.xlsx")) {
                  workbook.write(fileOut);
              }

              // Close the workbook
              workbook.close();

          driver.quit();
      }
	@SuppressWarnings("unused")
	private static void downloadFile(String fileURL) throws IOException {
    	    @SuppressWarnings("deprecation")
			URL url = new URL(fileURL);
    	    Path targetPath = Paths.get("C:\\Users\\deben\\Downloads\\RedhatPackages" + "/" + Paths.get(url.getPath()).getFileName());

    	    // Create directories if they do not exist
    	    Files.createDirectories(targetPath.getParent());
    	    
    	    try (BufferedInputStream in = new BufferedInputStream(url.openStream());
    	         FileOutputStream fileOutputStream = new FileOutputStream(targetPath.toString())) {
    	        byte dataBuffer[] = new byte[1024];
    	        int bytesRead;
    	        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
    	            fileOutputStream.write(dataBuffer, 0, bytesRead);
    	        }
    	    }
    	}

  }




//// Print all dropdown values
//System.out.println("Dropdown values:");
//for (String value : dropdownValues) {
//  System.out.println(value);
//}