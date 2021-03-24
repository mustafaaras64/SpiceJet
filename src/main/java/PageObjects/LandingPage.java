package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//trip
	private By roundtrip = By.xpath("//input[@value='RoundTrip']");
	//departure city
	private By departure = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	//arrival city
	private By arrival = By.name("ctl00_mainContent_ddl_destinationStation1_CTXT");
	//calender
	private By departDate = By.id("ctl00_mainContent_view_date1");
	private By selectedDepartDate = By.cssSelector("div[class='ui-datepicker-group ui-datepicker-group-last']>div+table>tbody>tr:nth-of-type(3)>td");
	private By returnDate = By.name("ctl00$mainContent$view_date2");
	private By selectedReturnDate = By.cssSelector("div[class='ui-datepicker-group ui-datepicker-group-last']>table>tbody>tr:nth-of-type(4)>td:nth-of-type(5)");
	private By next = By.cssSelector("a[class='ui-datepicker-next ui-corner-all']>span");
	//pessengers
	private By pessengers = By.id("divpaxinfo");
	private By adult = By.id("ctl00_mainContent_ddl_Adult");
	private By child = By.id("ctl00_mainContent_ddl_Child");
	private By infant = By.name("ctl00$mainContent$ddl_Infant");
	//currency
	private By currency = By.id("ctl00_mainContent_DropDownListCurrency");
	//search
	private By search = By.id("ctl00_mainContent_btn_FindFlights");
	
	
	public WebElement getRoundTrip() {
		return driver.findElement(roundtrip);
	}
	public WebElement getDeparture() {
		return driver.findElement(departure);
	}
	public WebElement getSelectedDepartDate() {
		return driver.findElement(selectedDepartDate);
	}
	public WebElement getArrival() {
		return driver.findElement(arrival);
	}
	public WebElement getDepartDate() {
		return driver.findElement(departDate);
	}
	public WebElement getReturnDate() {
		return driver.findElement(returnDate);
	}
	public WebElement getSelectedReturnDate() {
		return driver.findElement(selectedReturnDate);
	}
	public WebElement getNext() {
		return driver.findElement(next);
	}
	public WebElement getPessengers() {
		return driver.findElement(pessengers);
	}
	public WebElement getAdult() {
		return driver.findElement(adult);
	}
	public WebElement getChild() {
		return driver.findElement(child);
	}
	public WebElement getInfant() {
		return driver.findElement(infant);
	}
	public WebElement getCurrency() {
		return driver.findElement(currency);
	}
	public WebElement getSearch() {
		return driver.findElement(search);
	}
}