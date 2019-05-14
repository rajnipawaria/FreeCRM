package Com.CRM.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.CRM.QA.Util.TestUtil;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public Testbase() {
		
		try
		{
			prop =new Properties();
			FileInputStream fs=new FileInputStream("C:\\Users\\Rajni.Pawaria\\eclipse-workspace\\FreeCRM\\"
					+ "src\\main\\java\\Com\\CRM\\QA\\Config\\Config.properties");
			prop.load(fs);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	


public static void initialization()
{
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "");
		driver=new ChromeDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
		


}
}



