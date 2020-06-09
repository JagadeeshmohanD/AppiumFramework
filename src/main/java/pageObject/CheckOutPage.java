package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {
	
	//concatenate driver
		public CheckOutPage(AppiumDriver driver) {
			// TODO Auto-generated constructor stub
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}

		//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
		public List<WebElement> productlist;
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
		public List<WebElement> totalAmount;
		
		public List<WebElement> getProductList()
		{
			return productlist;
		}

}
