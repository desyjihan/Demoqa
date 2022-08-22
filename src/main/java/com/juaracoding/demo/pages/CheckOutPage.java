package com.juaracoding.demo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.demo.drivers.DriverSingleton;

public class CheckOutPage {

private WebDriver driver;
	
	public CheckOutPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='select2-billing_country-container']")
	private WebElement btnCountry;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputCountry;
	
	@FindBy(xpath = "//input[@id='billing_address_1']")
	private WebElement inputAddress;
	
	@FindBy(xpath = "//input[@id='billing_city']")
	private WebElement inputCity;
	
	@FindBy(xpath = "//span[@id='select2-billing_state-container']")
	private WebElement btnProvince;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement inputProvince;
	
	@FindBy(xpath = "//input[@id='billing_postcode']")
	private WebElement inputPostCode;
	
	@FindBy(xpath = "//input[@id='billing_phone']")
	private WebElement inputPhone;
	
	@FindBy(xpath = "//input[@id='terms']")
	private WebElement Accept;
	
	@FindBy(xpath = "//button[@id='place_order']")
	private WebElement btnPlaceOrder;
	
	public void country(String Cari) {
		btnCountry.click();
		inputCountry.sendKeys(Cari);
		inputCountry.sendKeys(Keys.ENTER);
	}
	
	public void Address(String address) {
		this.inputAddress.clear();
		this.inputAddress.sendKeys(address);
	}
	
	public void City(String city) {
		this.inputCity.clear();
		this.inputCity.sendKeys(city);
	}
	
	public void Province(String Cari) {
		btnProvince.click();
		inputProvince.sendKeys(Cari);
		inputProvince.sendKeys(Keys.ENTER);
	}
	
	public void postCode(String postCode) {
		this.inputPostCode.clear();
		this.inputPostCode.sendKeys(postCode);
	}
	
	public void Phone(String phone) {
		this.inputPhone.clear();
		this.inputPhone.sendKeys(phone);
	}
	
	public void accept() {
		Accept.click();
	}
	
	public void placeOrder() {
		btnPlaceOrder.click();
	}
}
