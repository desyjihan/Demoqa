package com.juaracoding.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.demo.drivers.DriverSingleton;

public class RegisPage {

	private WebDriver driver;
	
	public RegisPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[normalize-space()='My Account']")
	private WebElement btnMyAcc;
	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement regUserName;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement regEmail;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement regPassword;

	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnReg;
	
	@FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div[1]/ul/li/a")
	private WebElement btnAlert;
	
	public void regis(String regusername, String regemail, String regpassword) {
		this.regUserName.sendKeys(regusername);
		this.regEmail.sendKeys(regemail);
		this.regPassword.sendKeys(regpassword);
		btnReg.click();
	}
	
	public void myAcc() {
		btnMyAcc.click();
	}
	
	public void alert() {
		btnAlert.click();
	}
}
