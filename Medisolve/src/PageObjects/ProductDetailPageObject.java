package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDetailPageObject {
	WebDriver driver;
	
	@FindBy (xpath = "//ul[@class='breadcrumb-links']")
	private WebElement pageheader;
	
	@FindBy (id = "productname")
	private WebElement productHeader;
	
	@FindBy (xpath = "//a[@id='addtocart']")
	private WebElement addTocartBtn;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String isProductDetailPageLoaded() {
		String pageTitle = null;
		if(pageheader.isDisplayed()){
			pageTitle = pageheader.getText();
		}
		else {
			Assert.fail("Product details page doesnt load properly");
		}
		return pageTitle;
	}
	
	public String getProductName() {
		String productName = null;
		if(productHeader.isDisplayed()) {
			productName = productHeader.getText();
		}
		else {
			Assert.fail("Product is not displaying on product details page");
		}
		return productName;
	}
	
	public boolean verifyAddToCardButton() {
		boolean addToCartFlag = addTocartBtn.isDisplayed();
		return addToCartFlag;
	}

}
