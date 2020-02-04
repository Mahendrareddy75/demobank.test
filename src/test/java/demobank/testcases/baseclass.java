package demobank.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import demobank.utils.Readconfig;

public class baseclass {
	Readconfig readconfig=new Readconfig();
	
	public String baseurl=readconfig.getAppurl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
    public static Logger logger;
			@Parameters("browser")
			@BeforeClass
			
			public void setup(String brows)
			{
				
				logger=Logger.getLogger("ebanking");
				PropertyConfigurator.configure("log4j.properties");
				if(brows.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
					driver=new ChromeDriver();
				}else if(brows.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
					driver=new FirefoxDriver();
				}
				driver.get(baseurl);
			}
			@AfterClass
			public void tearDown()
			{
				driver.quit();
			}
			public void capturescreenshot(WebDriver driver, String tname) throws IOException {
				TakesScreenshot ts=(TakesScreenshot) driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				File  target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
				Files.copy(source, target);
				System.out.println("screenshot taken");
				
			}

}