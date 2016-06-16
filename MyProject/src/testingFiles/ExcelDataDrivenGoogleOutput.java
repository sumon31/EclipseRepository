package testingFiles;

	
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


	public class ExcelDataDrivenGoogleOutput {
        
		//public static WebDriver driver;
		
	//	@SuppressWarnings("unused")
		@Test
		public static void TestScenario() throws InterruptedException, IOException {
			// TODO Auto-generated method stub
				//FileInputStream file = new FileInputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results.xlsx");
                
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook();
		        XSSFSheet sheet = workbook.createSheet("GoogleSearch");
		        
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
                
//		        XSSFRow row = sheet.createRow(0);
//		
//		        row.createCell(0).setCellValue("Location");
//		        row.createCell(1).setCellValue("SearchResult");
//		        row.createCell(0).setCellStyle(my_style);
//		        row.createCell(1).setCellStyle(my_style);
		       
		       // row.createCell(0).getCellStyle().setFont(XSSFFont.BOLDWEIGHT_NORMAL);

		        
//		        List<String> countryName = new ArrayList<String>();
//				countryName.add("Bangladesh");
//				countryName.add("India");
//				countryName.add("Pakistan");
//				countryName.add("Dubai");
//				countryName.add("USA");
//				countryName.add("Europe");
				
		        String[] countryName = new String[6];
				countryName[0] = ("Bangladesh");
				countryName[1] = ("India");
				countryName[2] = ("Pakistan");
				countryName[3] = ("Dubai");
				countryName[4] = ("USA");
				countryName[5] = ("Europe");
				
				System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
				System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
				
				 WebDriver driver = new ChromeDriver();
				//WebDriver driver = new FirefoxDriver();
				driver.get("http://google.com");
				driver.manage().window().maximize();
					
				for(int i = 0; i < countryName.length; i++)
					
				{
					driver.navigate().to("http://google.com");	
					
					Thread.sleep(1000);
										
					driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(countryName[i]);
					
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//*[@id='sblsbb']/button/span")).click();
					
					
					row = sheet.createRow(i + 1);
					row.createCell(0).setCellValue(countryName[i]);
			       // row.createCell(1).setCellValue(SearchResult.get(i));
					
					Thread.sleep(2000);
					
					String searchResult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
					
					String[] arrSplit = searchResult.split(" ");
					
					row.createCell(1).setCellValue(arrSplit[1]);
					
					
					if(arrSplit[1] != null){
					  System.out.println("Passed - The number of search result in " + countryName[i] + " is " + arrSplit[1]);
					  Reporter.log("Passed - The number of search result in " + countryName[i] + " is " + arrSplit[1]);
					}else{
					  System.out.println("Failed - The number of search result in " + countryName[i] + " is empty/incorrect " + arrSplit[1]);
					  org.testng.Assert.fail("Failed - The number of search result in " + countryName[i] + " is empty/incorrect " + arrSplit[1]);
					  driver.close();
					}
					
					sheet.autoSizeColumn(0);
					sheet.autoSizeColumn(1);

				}
				
				driver.close();
			//}	
				//file.close();
	           //saving the file as different name
			    //FileOutputStream outFile =new FileOutputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results.xlsx");

		        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results.xlsx"));
		        workbook.write(outFile);
		        outFile.close(); 
	}
		
	}

	
    
   

    