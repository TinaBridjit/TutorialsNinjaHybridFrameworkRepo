package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {

WebDriver driver=null;
	
	public Properties prop;
	public Properties dataprop;
	
	public  Base() 
	{
		prop=new Properties();
		File propfile=new File("config.properties");
		//File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\c.properties");
		try {
		     FileInputStream fis=new FileInputStream(propfile);
		     prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		dataprop=new Properties();
		File datapropfile=new File("testdata.properties");
		//File datapropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis=new FileInputStream(datapropfile);
		dataprop.load(datafis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	}
	public WebDriver InitialiseBrowserAndOpenApplicationURL(String browserName)
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
