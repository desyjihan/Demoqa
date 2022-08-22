package com.juaracoding.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.demo.drivers.DriverSingleton;
import com.juaracoding.demo.pages.CheckOutPage;
import com.juaracoding.demo.pages.LoginPage;
import com.juaracoding.demo.pages.LogoutPage;
import com.juaracoding.demo.pages.RegisPage;
import com.juaracoding.demo.pages.SearchPage;

public class TestDemo {

	public static WebDriver driver;
	private SearchPage searchPage;
	private RegisPage regisPage;
	private LoginPage loginPage;
	private CheckOutPage checkOutPage;
	private LogoutPage logoutPage;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		
		regisPage = new RegisPage();
		loginPage = new LoginPage();
		searchPage = new SearchPage(driver);
		checkOutPage = new CheckOutPage();
		logoutPage = new LogoutPage();
	}
	
	@Test(priority = 1)
	public void myAcc(){
		scroll(400);
		regisPage.myAcc();
	}
	
	@Test(priority = 2)
	public void Regis(){
		regisPage.regis("jihan", "jihan@test.com", "jihan.123.asd");
		System.out.println("Input Regis Success");
		scroll(600);
		delay(3);
		regisPage.alert();
		delay(3);
	}

	@Test(priority = 3)
	public void Login(){
		loginPage.remember();
		delay(3);
		loginPage.login("", "jihan.123.asd");
		System.out.println("Input Login Success");
		scroll(400);
		delay(3);
		
	}
	
	@Test(priority = 4)
	public void cariWishList1() {
		scroll(-400);
		delay(3);
		searchPage.SearchItem("Pink Floral");
		scroll(600);
		searchPage.wishList();
		delay(2);
		searchPage.Logo();
		scroll(400);
	}
	
	@Test(priority = 5)
	public void cariWishList2() {
		searchPage.SearchItem("White Lace");
		scroll(700);
		searchPage.wishList();
		delay(2);
		searchPage.Logo();
		scroll(400);
		searchPage.MyWishList();
		scroll(400);
	}
	
	@Test(priority = 6)
	public void MyWishList() {
		searchPage.Options();
		searchPage.AlertDismiss();
		scroll(400);
		searchPage.SelectColorSizeCart(1,3);
		
	}
	
	@Test(priority = 7)
	public void MyWishList2() {
		searchPage.Logo();
		scroll(400);
		searchPage.MyWishList();
		delay(3);
		searchPage.Options2();
		scroll(500);
		searchPage.SelectSizeCart(3);
		scroll(400);
	}
	
	@Test(priority = 8)
	public void ShowCart() {
		searchPage.ViewCart();
		scroll(500);
		delay(3);
		scroll(600);
		searchPage.checkOut();
		delay(3);
	}
	
	@Test(priority = 9)
	public void CheckOut() {
		scroll(400);
		checkOutPage.country("Indonesia");
		checkOutPage.Address("Tembalang");
		checkOutPage.City("Semarang");
		checkOutPage.Province("Jawa Tengah");
		checkOutPage.postCode("50277");
		checkOutPage.Phone("082220000012");
		delay(3);
		checkOutPage.accept();
		checkOutPage.placeOrder();
		delay(3);
		scroll(500);
		searchPage.Logo();
	}
	
	@Test(priority = 10)
	public void LogOut() {
		searchPage.Logo();
		scroll(400);
		regisPage.myAcc();
		logoutPage.logout();
		scroll(600);
	}

	@AfterClass
	public void closeBrowser() {
		delay(10);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
}
}
