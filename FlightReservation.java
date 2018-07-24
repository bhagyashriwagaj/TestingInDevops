package com.afsar.framework.tests.FlightReservation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightReservation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Afsar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");

		System.out.println("URL is launched successfully");

		driver.findElement(By.name("userName")).sendKeys("mercury"); // username

		driver.findElement(By.name("password")).sendKeys("mercury");// password

		driver.findElement(By.name("login")).click();

		System.out.println("Login button is clicked");

		String title=driver.getTitle();

		if(title.contentEquals("Find a Flight: Mercury Tours:")){

			System.out.println("PASS : Test case is passed ");
		}else {

			System.out.println("FAILED : test case failed");
		}

		driver.findElement(By.linkText("SIGN-OFF")).click();
		System.out.println("Sign off Sucessful");

		//************************** End of First Scenario ****************************************************

		//Second Scenario

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);// implicitly wait

		driver.findElement(By.linkText("REGISTER")).click();

		//Fname
		driver.findElement(By.name("firstName")).sendKeys("Afsar");

		//LName
		driver.findElement(By.name("lastName")).sendKeys("Ali");

		//Mobile
		driver.findElement(By.name("phone")).sendKeys("8097455609");

		//Email
		driver.findElement(By.id("userName")).sendKeys("rpaautomationtraining@gmail.com");

		// Mailing Information

		//Address
		driver.findElement(By.name("address1")).sendKeys("Andheri ,Mumbai");

		driver.findElement(By.name("address2")).sendKeys("Odisha");

		//city

		driver.findElement(By.name("city")).sendKeys("Mumbai");
		//State
		driver.findElement(By.name("state")).sendKeys("MH");

		//ZIP Code
		driver.findElement(By.name("postalCode")).sendKeys("400090");

		//Country

		WebElement country=driver.findElement(By.name("country"));

		Select  sel=new Select(country);

		sel.selectByVisibleText("INDIA");

		//**************************************
		//  User Information

		//username
		driver.findElement(By.id("email")).sendKeys("rpaautomation");

		//password
		driver.findElement(By.name("password")).sendKeys("password");

		//Confirm password
		driver.findElement(By.name("confirmPassword")).sendKeys("password");

		//Submit button

		driver.findElement(By.name("register")).click();

		if(driver.getCurrentUrl().contentEquals("http://newtours.demoaut.com/create_account_success.php")){

			System.out.println("Account Creation is successful");
		}else{

			System.out.println("Failed to create an account ");
		}

		driver.findElement(By.linkText("sign-in")).click();

		//******************************************************
		// Login Page

		driver.findElement(By.name("userName")).sendKeys("rpaautomation");
		driver.findElement(By.name("password")).sendKeys("password");

		driver.findElement(By.name("login")).click();

		System.out.println("Successful Login using new Username and Password ");


		//*************************************************************************

		//**********Start of Flight Finder Page ***********************************

		//passenger count
		WebElement nos_ofPassenger=driver.findElement(By.name("passCount"));

		Select pass=new Select(nos_ofPassenger);
		pass.selectByVisibleText("2");// 2 is being selected

		//Departing from
		Select depart=new Select(driver.findElement(By.name("fromPort")));
		depart.selectByVisibleText("Frankfurt");

		//on
		Select on =new Select(driver.findElement(By.name("fromMonth")));
		on.selectByVisibleText("May");

		//Arriving in
		Select arrive=new Select(driver.findElement(By.name("toPort")));
		arrive.selectByVisibleText("New York");

		//Returning
		Select rtrn=new Select(driver.findElement(By.name("toMonth")));
		rtrn.selectByVisibleText("June");

		//***Preferences
		//Service Class --> Business Class radio button select
		driver.findElement(By.xpath(".//input[@name='servClass' and @value='Business']")).click();

		//Airline
		Select airline=new Select(driver.findElement(By.name("airline")));
		airline.selectByVisibleText("Blue Skies Airlines");

		//Continue button
		driver.findElement(By.name("findFlights")).click();
		System.out.println("Clicked on the continue button on find flight page");

		//*** Select Flight Page ******************

		//Select Flight -Depart
		List<WebElement> deparFlight=driver.findElements(By.xpath(".//input[@name='outFlight']"));

		deparFlight.get(2).click(); // Selecting third row flight from depart


		//Select Flight - Return
		List<WebElement> returnFlight=driver.findElements(By.xpath(".//input[@name='inFlight']"));
		returnFlight.get(1).click(); // Selecting second row from return flights

		//Continue button
		driver.findElement(By.name("reserveFlights")).click();
		System.out.println("Continue button is clicked on the Select flight page");

		//**************Start of Book a Flight page *************************************

		//Passengers
		//FirstName 1
		driver.findElement(By.name("passFirst0")).sendKeys("Afsar1");

		//Last Name 1
		driver.findElement(By.name("passLast0")).sendKeys("Ali1");

		//Meal 1
		Select meal1=new Select(driver.findElement(By.name("pass.0.meal")));
		meal1.selectByVisibleText("Low Calorie");

		//Passengers -2
		//FirstName 2
		driver.findElement(By.name("passFirst1")).sendKeys("Afsar2");

		//Last Name 2
		driver.findElement(By.name("passLast1")).sendKeys("Ali2");

		//Meal 2
		Select meal2=new Select(driver.findElement(By.name("pass.1.meal")));
		meal2.selectByVisibleText("Low Sodium");



	}

}
