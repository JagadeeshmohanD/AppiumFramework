package Practice.AppiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.CheckOutPage;
import pageObject.FormPage;




public class Ecommerce_tc_4 extends ecommerce{
	
	//public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//General-Store.apk4.0
		
		@Test
		
		public void totalvalidation() throws IOException, InterruptedException 
		{
		
			service=stratServer();
		AndroidDriver<AndroidElement> driver =capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage formpage = new FormPage(driver);
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		//formpage.nameField.sendKeys("Hello");
		formpage.getNameField().sendKeys("Hello");
	    driver.hideKeyboard();
	    //driver.findElement(By.xpath("//*[@text='Female']")).click();
	    formpage.femalOption.click();
	    //driver.findElement(By.id("android:id/text1")).click();
	    formpage.getcountrySelection().click();
	    
	    Utilities u = new Utilities(driver);
	    u.scrollToText("Argentina");
	    //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

	  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

	     //driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	     formpage.countryArgentina.click();
	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	Thread.sleep(4000);

	int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

	double sum=0;
	CheckOutPage checkoutpage = new CheckOutPage(driver);
	
	for(int i=0;i<count;i++)
	{
	//String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
	String amount1= checkoutpage.productlist.get(i).getText();
	double amount=getAmount(amount1);

	sum=sum+amount;//280.97+116.97

	}

	System.out.println(sum+"sum of products");



	//String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	String total=((WebElement) checkoutpage.totalAmount).getText();
	


	total= total.substring(1);

	double totalValue=Double.parseDouble(total);

	System.out.println(totalValue+"Total value of products");
	
	
	Assert.assertEquals(sum,totalValue);

	//Mobile Gestures

	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	TouchAction t=new TouchAction(driver);

	t.tap(tapOptions().withElement(element(checkbox))).perform();



	WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

	t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

	driver.findElement(By.id("android:id/button1")).click();

	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	service.stop();

	}
//	} kill all apium node 4723
		@BeforeTest
		public void killAllNodes() throws IOException, InterruptedException
		{
		//taskkill /F /IM node.exe
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(3000);
			
		}
		

	public static double getAmount(String value)

	{

	value= value.substring(1);

	double amount2value=Double.parseDouble(value);

	return amount2value;

	}

}
