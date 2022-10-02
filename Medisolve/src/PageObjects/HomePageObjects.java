package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageObjects {
	WebDriver driver;
	
	@FindBy (xpath = "//div[@class='logo']/a/img")
	private WebElement logo;
	
	@FindBy (xpath = "//span[@id='x']")
	private WebElement closeBtnOnIntroPopup;
	
	@FindBy (xpath = "//input[@id='key']")
	private WebElement searchBar;
	
	@FindBy (xpath = "//button/i[@class='ion-ios-search-strong']")
	private WebElement searchIcon;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoPresent() {
		boolean logoFlag = logo.isDisplayed();
		return logoFlag;
	}
	
	public void clickOnLogo() {
		logo.click();
	}
	
	public void closeIntroPopup() {
		if(closeBtnOnIntroPopup.isDisplayed()) {
			closeBtnOnIntroPopup.click();
		}
		else {
			System.out.println("Intro Popup is not displaying");
		}
	}
	
	public boolean isSearchBarPresent() {
		boolean searchBarFlag = searchBar.isDisplayed();
		return searchBarFlag;
	}
	
	public void setSearchBarField(String input) {
		searchBar.sendKeys(input);
	}
	
	public boolean isSearchIconPresent() {
		boolean searchIconFlag = searchIcon.isDisplayed();
		return searchIconFlag;
	}
	
	public void clickSearchIcon() {
		searchIcon.click();
	}
	

}
