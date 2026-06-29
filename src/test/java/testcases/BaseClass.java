package testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass (groups= {"sanity","Regresssion","Master"})
	@Parameters({"os", "browser"})
	public void setup(	String os, String br) throws IOException
	{    // <-- Add the arguments inside the parentheses

	// loading config.propertfile
	FileReader file=new FileReader(".//src//test//resources//config.properties");
	
	p = new Properties();
	p.load(file);
	
	
	logger=LogManager.getLogger(this.getClass());
		
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN10);
		}
	
	else if(os.equalsIgnoreCase("mac"))
	{
		capabilities.setPlatform(Platform.MAC);
	}
	else
	{
		System.out.println("No matching os");
		return;
	}
		
		// Browser 
		switch(br.toLowerCase())
		{
		case "chrome":capabilities.setBrowserName("chrome"); break;
		case "edge":capabilities.setBrowserName("MicrosoftEdge"); break;
         default: System.out.println("No matcing browser"); return;
		}
		
		driver =new RemoteWebDriver(new URL("http://192.168.0.175:4444"),capabilities);
	}	
	
	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver(); break;
		case "firefox": driver=new ChromeDriver();
         default: System.out.println("No matcing browser"); return;
		}
		
}
		switch(br.toLowerCase())
		{
		case"chrome" : driver=new ChromeDriver(); break;
		case"edge" : driver=new EdgeDriver(); break;
		case"firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("inavid browser name...."); return;

		}
		
		
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(p.getProperty("appurl"));
	driver.manage().window().maximize();
	
	}
	@AfterClass(groups= {"sanity","Regresssion","Master"})
  public void tearDown()
	{
		driver.quit();
	}
	
	
	public	String randomeString()
	{
	String	generatedstring=RandomStringUtils.randomAlphabetic(5);
	return    generatedstring;
	}
	
 public	String randomeNumber()
	{
	String	generatednumber=RandomStringUtils.randomNumeric(10);
	return    generatednumber;

	}
 
 public	String randomeAlpaNumeric()
	{
	String	generatedString=RandomStringUtils.randomNumeric(3);
	String	generatednumber=RandomStringUtils.randomNumeric(3);

	return    (generatedString+"@"+generatednumber);

	}
 public String captureScreen(String tname) {
	// 1. Create a unique timestamp for the screenshot file name
	 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	    String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile=new File(targetFilePath);
	    
	    sourceFile.renameTo(targetFile);
	    
	    return targetFilePath;
 }
 

	
	
}
