package transaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	private WebDriver webdriver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muasif\\Desktop\\chromedriver\\chromedriver.exe");
		webdriver = new ChromeDriver();
	}

	@Given("^Order is placed$")
	public void order_is_placed() throws Throwable {
		WebElement acceptTC = webdriver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();

		WebElement placeOrder = webdriver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
	}

	@When("^Navigated to payment page$")
	public void navigated_to_payment_page() throws Throwable {
		webdriver.get("//payment page url");
	}

	@Then("^Get transaction details$")
	public void get_transaction_details() throws Throwable {

	}

	@Given("^Payment details$")
	public void payment_details() throws Throwable {

	}

	@When("^valid payment details$")
	public void valid_payment_details() throws Throwable {

	}

	@Then("^confirm transaction$")
	public void confirm_transaction() throws Throwable {

	}

	@Then("^get money from user's account$")
	public void get_money_from_user_s_account() throws Throwable {

	}

	@Then("^update CapStore revenue$")
	public void update_CapStore_revenue() throws Throwable {

	}
}
