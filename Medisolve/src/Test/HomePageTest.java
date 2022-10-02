package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.ProductDetailPageObject;
import PageObjects.SearchedProductsPageObject;

public class HomePageTest {
	WebDriver driver;
	HomePageObjects hpo;
	SearchedProductsPageObject sppo;
	ProductDetailPageObject pdpo;
	
	@BeforeSuite
	void initSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akash Kare\\OneDrive\\Documents\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	void launchURL() {
		driver.get("https://medisolve.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@BeforeClass
	void initObjs() {
		hpo = new HomePageObjects(driver);
		sppo = new SearchedProductsPageObject(driver);
		pdpo = new ProductDetailPageObject(driver);
	}
	
	@Test(priority=1)
	void urlTest() {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl , "https://medisolve.co.in/" , "URL Test is successful");
	}
	
	@Test(priority=2)
	void logoTest() {
		hpo.closeIntroPopup();
		boolean actualLogo = hpo.isLogoPresent();
		Assert.assertTrue(actualLogo, "Logo Test is Successful");
	}
	
	@Test(priority=3)
	void searchFieldTest()
	{
		boolean searchBarFlag = hpo.isSearchBarPresent();
		Assert.assertTrue(searchBarFlag, "Search Field is Displayimg on Home Page");
		hpo.setSearchBarField("Blood pressure");
		Assert.assertTrue(hpo.isSearchIconPresent(), "Search Icon is Present");
		hpo.clickSearchIcon();
		sppo.validateHeaderPage("Searched Products");
		sppo.clickFirstProduct();
		String actualHeader = pdpo.isProductDetailPageLoaded();
		Assert.assertEquals(actualHeader, "Home Product Detail", "Successfully navigated to Product Details Page");
		String actualProductName = pdpo.getProductName();
		Assert.assertEquals(actualProductName, "ACCUSURE TD BLOOD PRESSURE MONITORING SYSTEM (1 PC)" , "Correct Product is displaying");
		boolean actualAddtoCartFlag = pdpo.verifyAddToCardButton();
		Assert.assertTrue(actualAddtoCartFlag, "Add to cart button is displaying for product = " +actualProductName + ".");
	}
	
	@AfterClass
	void closeBrowser() throws InterruptedException {
		Thread.sleep(10);
		driver.quit();
	}

}
