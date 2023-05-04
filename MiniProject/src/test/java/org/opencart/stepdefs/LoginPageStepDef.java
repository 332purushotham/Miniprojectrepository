package org.opencart.stepdefs;

import org.cart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageStepDef {
private WebDriver driver;
private LoginPage loginPage;
@Before
public void setup()
{
	WebDriverManager.chromedriver().setup();
driver =new ChromeDriver();	
}
@Given("I am on the OpenCart login page")
public void i_am_on_the_open_cart_login_page() {
	driver.get("https://ui.cogmento.com/");
	 loginPage=new LoginPage(driver);
}
@Given("I have entered a valid username and password")
public void i_have_entered_a_valid_username_and_password() {
	loginPage.enterEmail("purushothamvirtusa3322@gmail.com");
	loginPage.enterPassword("Puru@4321");
}
@When("I click on the login button")
public void i_click_on_the_login_button() {
	loginPage.clickLoginButton();
}
@Then("I should be logged in successfully")
public void i_should_be_logged_in_successfully() {
    Assert.assertEquals(loginPage.checkLogoutLink(), true);
}

@Given("I have entered invalid {string} and {string}")
public void i_have_entered_invalid_and(String username12, String password) {
	loginPage.enterEmail(username12);
	loginPage.enterPassword(password);
}
@Then("I should see an error message indicating {string}")
public void i_should_see_an_error_message_indicating(String errorMessage) {
	  Assert.assertEquals( driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
}

}
