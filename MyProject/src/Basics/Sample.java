package Basics;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Sample {
    private static WebDriver driver;
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("GoogleSearch");
	
    @Test
    public void FireFoxTesting() throws Exception {
		//Thread.sleep(300);
    	driver = new FirefoxDriver();
    	System.out.println("Started Test on FireFox");
    	//Thread.sleep(650);
    	GoogleSearchResult();
    	
        System.out.println("Completed Test on FireFox");
        
        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results_FireFox.xlsx"));
        workbook.write(outFile);
        outFile.close(); 
        
    }
	
    @Test
    public void ChromeTesting() throws Exception {
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
    	 driver = new ChromeDriver();
		 System.out.println("Started Test on Chrome");
		 GoogleSearchResult();
         System.out.println("Completed Test on Chrome");
         
         FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results_Chrome.xlsx"));
         workbook.write(outFile);
         outFile.close(); 
    }
    
    @Test
    public void InternetExplorerTesting() throws Exception {
		 //Thread.sleep(600);
    	 System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
    	 driver = new InternetExplorerDriver();
		 System.out.println("Started Test on IE");
		 GoogleSearchResult();         
         System.out.println("Completed Test on IE");
         
         FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results_IE.xlsx"));
         workbook.write(outFile);
         outFile.close(); 
    }
    
    
    public void GoogleSearchResult() throws Exception {
    	
		//@SuppressWarnings("resource")
        
	    XSSFRow row = sheet.createRow(0);

	    XSSFCellStyle style = workbook.createCellStyle();
	    style.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());

	    //style.setFillPattern(XSSFCellStyle.FINE_DOTS);
	    style.setFillPattern(XSSFCellStyle.BORDER_THIN);

	    
	    XSSFFont font = workbook.createFont();
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        style.setFont(font);
                    
        
	    XSSFCell cell1 = row.createCell(0);
	    cell1.setCellValue("Location");
	    cell1.setCellStyle(style);
	    
	    XSSFCell cell2 = row.createCell(1);
	    cell2.setCellValue("Results");
	    cell2.setCellStyle(style);

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        
        List<String> countryName = new ArrayList<String>();
		countryName.add("Bangladesh");
		countryName.add("India");
		countryName.add("Pakistan");
		countryName.add("Dubai");
		countryName.add("USA");
		countryName.add("Europe");
		
		List<String> SearchResult = new ArrayList<String>();
		SearchResult.add("100000");
		SearchResult.add("200000");
		SearchResult.add("300000");
		SearchResult.add("400000");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
		
       // Thread.sleep(500);
		driver.get("http://google.com");
		//driver.manage().window().maximize();
			
		for(int i = 0; i < countryName.size(); i++)
			
		{
			driver.navigate().to("http://google.com");	
			
			Thread.sleep(1000);
								
			driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(countryName.get(i));
			
			driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();
			
			row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(countryName.get(i));
	       // row.createCell(1).setCellValue(SearchResult.get(i));
			
			Thread.sleep(2000);
			
			String searchResult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
			
			String[] arrSplit = searchResult.split(" ");
			
			row.createCell(1).setCellValue(arrSplit[1]);
			
			System.out.println("The number of search result in " + countryName.get(i) + " is " + arrSplit[1]);
			
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);

		}
		
		driver.close();		
        
    }       
}