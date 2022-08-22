package com.juaracoding.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.demo.drivers.DriverSingleton;

public class LogoutPage {

private WebDriver driver;
	
	public LogoutPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement Logout;
	
	public void logout() {
		Logout.click();
	}
}
