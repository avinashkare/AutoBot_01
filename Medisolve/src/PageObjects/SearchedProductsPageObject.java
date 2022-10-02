package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchedProductsPageObject {
	WebDriver driver;
	Actions act;
	
	@FindBy (xpath = "//h1[@class='breadcrumb-hrading']")
	private WebElement pageHeader;
	
	@FindBy (xpath = "//div[@id='shop-1']//article")
	private WebElement firstProduct;
	
	public SearchedProductsPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validateHeaderPage(String expectedHeader) {
		String actualHeader = pageHeader.getText();
		Assert.assertEquals(actualHeader, expectedHeader, "Successfully Navigated to header Page");
	}
	
	public void clickFirstProduct() {
		if(firstProduct.isDisplayed()) {
			act = new Actions(driver);
			act.moveToElement(firstProduct).click().build().perform();
		}
		else {
			Assert.fail("Product is not dispalying");
		}
	}

}
