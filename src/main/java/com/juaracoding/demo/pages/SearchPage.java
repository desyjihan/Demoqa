package com.juaracoding.demo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btnAlert;

	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@name='s']")
	private WebElement InputSearch;

	@FindBy(xpath="//select[@id='pa_color']")
	private WebElement InputColor;

	@FindBy(xpath="//*[@id=\"pa_size\"]")
	private WebElement InputSize;

	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	private WebElement btnAddCart;
	
	@FindBy(xpath="//div[@class='summary entry-summary']//div[1]//a[1]")
	private WebElement btnWishList;
	
	@FindBy(xpath="//*[@id=\"noo-site\"]/header/div[2]/div/div/div/div")
	private WebElement btnLogo;
	
	@FindBy(xpath="//a[normalize-space()='My Wishlist']")
	private WebElement btnMyWishList;
	
	@FindBy(xpath="//*[@id=\"yith-wcwl-row-1259\"]/td[6]")
	private WebElement btnOptions;
	
	@FindBy(xpath="//*[@id=\"yith-wcwl-row-1194\"]/td[6]/a")
	private WebElement btnOptions2;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement Alert;

	@FindBy(xpath="//a[@class='button wc-forward']")
	private WebElement btnCart;
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement btnCheckOut;

	public void AlertDismiss() {
		btnAlert.click();
	}

	public void SearchItem(String Cari) {
		btnSearch.click();
		InputSearch.sendKeys(Cari);
		InputSearch.sendKeys(Keys.ENTER);
	}
	
//	public void SelectSizeList(int size) {
//		Select ukuran = new Select(InputSize);
//		ukuran.selectByIndex(size);
//		btnWishList.click();
//	}
//
//	
//	public void SelectColorSizeList(int color, int size) {
//		Select warna = new Select(InputColor);
//		Select ukuran = new Select(InputSize);
//		warna.selectByIndex(color);
//		ukuran.selectByIndex(size);
//		btnWishList.click();
//	}
	
	public void SelectSizeCart(int size) {
		Select ukuran = new Select(InputSize);
		ukuran.selectByIndex(size);
		btnAddCart.click();
		System.out.println(Alert.getText());
	}

	
	public void SelectColorSizeCart(int color, int size) {
		Select warna = new Select(InputColor);
		Select ukuran = new Select(InputSize);
		warna.selectByIndex(color);
		ukuran.selectByIndex(size);
		btnAddCart.click();
		System.out.println(Alert.getText());
	}
	
	public void wishList() {
		btnWishList.click();
	}
	
	public void Logo() {
		btnLogo.click();
	}
	
	public void MyWishList() {
		btnMyWishList.click();
	}
	
	public void Options() {
		btnOptions.click();
	}
	
	public void Options2() {
		btnOptions2.click();
	}

	public void ViewCart() {
		btnCart.click();
	}
	
	public void checkOut() {
		btnCheckOut.click();
	}
}
