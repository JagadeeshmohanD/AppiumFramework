package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	//concatenate driver
	public FormPage(AppiumDriver driver)
	{
	  	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//*[@text='Female']")).click();
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femalOption;
	
	//driver.findElement(By.id("android:id/text1")).click();
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	//driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement countryArgentina;
	
	public WebElement getNameField() {
		System.out.println("Trying to find the Name");
		return nameField;
	}
	
	public WebElement getcountrySelection() {
		System.out.println("Trying to select the country");
		return countrySelection;
	}
}
