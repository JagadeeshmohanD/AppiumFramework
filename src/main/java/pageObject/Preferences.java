package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {
	
	public Preferences(AppiumDriver driver)
	{
	  	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependencies;
	//findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']")
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement checkbox;
	//driver.findElementById("android:id/checkbox")
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement RelativeLayout;
	//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]")
	
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement EnterText;
	//driver.findElementByClassName("android.widget.EditText")
	
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> buttons;
	//driver.findElementsByClassName("android.widget.Button")
	
}
