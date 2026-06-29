import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;

	@BeforeClass
	  public	void setup()
		{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().maximize();
		
		}
		@AfterClass
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
	
}



