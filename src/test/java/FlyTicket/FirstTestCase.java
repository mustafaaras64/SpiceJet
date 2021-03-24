package FlyTicket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.BasePage;



public class FirstTestCase extends BasePage{
	public WebDriver driver;
	public LandingPage lp;
	private Select adultDropDown;
	private Select childDropDown;
	private Select infantDropDown;
	
	private static Logger log = LogManager.getLogger(FirstTestCase.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		log.info("Driver is initializing");
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		log.info("Driver is closing");
		driver.close();
	}
	
	@Test(priority=1)
	public void RoundTripTest() {
		lp = new LandingPage(driver);
		lp.getRoundTrip().click();
		Assert.assertTrue(lp.getRoundTrip().isSelected());
	}
		
	@Test(dependsOnMethods= {"RoundTripTest"})
	public void DepartureTest() throws InterruptedException {
		lp = new LandingPage(driver);
		lp.getDeparture().sendKeys("BLR");
		Thread.sleep(2000);	
	}
	
	@Test(priority=2)
	public void ArrivalTest() {
		lp = new LandingPage(driver);
		lp.getArrival().sendKeys("MAA");
	}
		
	@Test(priority=3)
	public void CalenderTest() {
		lp = new LandingPage(driver);
		lp.getSelectedDepartDate().click();
		lp.getReturnDate().click();
		lp.getSelectedReturnDate().click();
	}
		
	@Test(priority=4)
	public void PessengersTest() {
		lp = new LandingPage(driver);
		adultDropDown = new Select(lp.getAdult());
		childDropDown = new Select(lp.getChild());
		infantDropDown = new Select(lp.getInfant());

		lp.getPessengers().click();
		lp.getAdult().click();
		for (int i = 0; i < 4; i++) {
			adultDropDown.selectByIndex(i);
		}
		Assert.assertEquals(lp.getPessengers().getText(), "4 Adult");

		lp.getChild().click();
		for (int i = 0; i < 4; i++) {
			childDropDown.selectByIndex(i);
		}
		Assert.assertEquals(lp.getPessengers().getText(), "4 Adult, 3 Child");

		lp.getInfant().click();
		for (int i = 0; i < 3; i++) {
			infantDropDown.selectByIndex(i);
		}
		Assert.assertEquals(lp.getPessengers().getText(), "4 Adult, 3 Child, 2 Infant");
	}
	
	@Test(priority=5)
	public void CurrencyTest() {
		lp = new LandingPage(driver);
		Select currencydropdown = new Select(lp.getCurrency());
		currencydropdown.selectByIndex(5);
	}

	@Test(groups= {"Smoke"})
	public void SearchButtonTest() {
		lp = new LandingPage(driver);
		lp.getSearch().click();
	}
	
	@Test
	public void FailureTest() {
		Assert.assertTrue(false);
	}	
}
