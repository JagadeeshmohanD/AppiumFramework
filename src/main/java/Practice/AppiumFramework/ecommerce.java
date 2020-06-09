package Practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ecommerce {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;
	
	public AppiumDriverLocalService stratServer() 
	{
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
			return service;
			
		}
		
	public static boolean checkIfServerIsRunnning(int port) {
			
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				
				serverSocket.close();
			} catch (IOException e) {
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}
//***start emulator on fly***//
	public static void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		        
		        //System.getProperty("user.dir");
		        FileInputStream fis = new FileInputStream("C:\\Software\\Workspace\\JavaPractice\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\Practice\\AppiumFramework\\global.properties");
		        Properties prop = new Properties();
		        prop.load(fis);
		        
		        
				File F = new File("src");
				File fs = new File(F,(String) prop.get(appName));
				DesiredCapabilities cap = new DesiredCapabilities();
			   String device=(String) prop.get("device");
			   //To run device name from command prompt use **mvn test -DdeviceName=Nexus** and remove device from global properties
			   //String device=System.getProperty("deviceName");
			    if(device.contains("emulator"))
			    {
			    startEmulator();
			    }
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, 8);
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
				cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
				//cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\kusuma\\Downloads\\General-Store.apk");
				cap.setCapability("chromedriverExecutable", "C:\\Users\\kusuma\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
				AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				return driver;
	}
	
	
//	public static void getScreenshot(String s) throws IOException
//	{
//	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
//	}

}
