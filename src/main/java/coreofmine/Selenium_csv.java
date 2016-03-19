package coreofmine;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
 

public class Selenium_csv 
{
	public static void main(String[] args) throws IOException
	{
		String csvFile = "./src/main/resources/Test.csv";
		BufferedReader br = null;
		String line = null; 
		String SplitBy = ";";
				
		String text_case_id = null;
		String url = null;
		String title_expected = null;
		br = new BufferedReader(new FileReader(csvFile));
		
		WebDriver driver = new FirefoxDriver();
		
		while ((line = br.readLine()) != null)
		{
			String[] csv = line.split(SplitBy);
			text_case_id = csv[0];
			url = csv[1];
			title_expected = csv[2];
				
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			System.out.println("");
			
			if (title_expected.equals(title_actual))
				{
					System.out.println("Test Case ID: \t\t" + text_case_id);
					System.out.println("URL: \t\t\t"+ url);
					System.out.println("Title expected: \t\t" + title_expected);
					System.out.println("Title actual: \t\t" + title_actual);
					System.out.println("Test case result: \t" + "PASSED");
								
				}
			else
				{
					System.out.println("Test Case ID: \t\t" + text_case_id);
					System.out.println("URL: \t\t\t"+ url);
					System.out.println("Title expected: \t\t" + title_expected);
					System.out.println("Title actual: \t\t" + title_actual);
					System.out.println("Test case result: \t" + "FAILED");
				}
		}
		
		driver.quit();
		br.close();
		
		}
	}