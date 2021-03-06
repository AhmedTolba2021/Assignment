package StepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import Pages.AddtocartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDef_UI {
	public static WebDriver driver;
	public static String NewNum = ""+(int)(Math.random()*Integer.MAX_VALUE);
	public static String EmailAddress = "EmailTest"+NewNum+"@test.io";
	
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("resolution", "1024x768");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	@Given("^User navigate to automationpractice web$")
	public void user_navigate_to_automationpractice_web() throws IOException {
		HomePage hpage = new HomePage(driver);
		hpage.SetUpChrome();
	}

	@When("^Enter email and click on Create button$")
	public void enter_email_and_click_on_Create_button() throws Exception  {
		HomePage hpage= new HomePage(driver);
		RegistrationPage RegPage = new RegistrationPage(driver);
		RegPage=hpage.RegisterEmail(EmailAddress);
	}

	@When("^User Fill the required fields with valid data$")
	public void user_Fill_the_required_fields_with_valid_data() throws Exception  {
		RegistrationPage RegPage = new RegistrationPage(driver);
		LoginPage LoPage = new LoginPage(driver);
		 LoPage= RegPage.FillingForm("FnameTest", "LnameTest", "123456", "TestAddress","TestCity", "12345", "123456780");
	}


	@When("^user navigate to my account page and signout$")
	public void user_navigate_to_my_account_page_and_signout() throws Exception  {
		Assert.assertEquals(driver.getTitle(), "My account - My Store"); 
		LoginPage LoPage = new LoginPage(driver);
		HomePage hpage= new HomePage(driver);
		hpage= LoPage.Logout();
	}

	@Then("^user returned to the homepage$")
	public void user_returned_to_the_homepage(){
		Assert.assertEquals(driver.getTitle(), "Login - My Store"); 
	}
	
	@Given("^User Login with the new credentials$")
	public void user_Login_with_the_new_credentials() throws Exception  {
		HomePage hpage= new HomePage(driver);
		LoginPage LoPage = new LoginPage(driver);
		LoPage= hpage.Login(EmailAddress, "123456");
	}

	@When("^Select the blouses and change its color and size$")
	public void select_Blouses_from_woman_cateogory() throws Exception {
		LoginPage LoPage = new LoginPage(driver);
		AddtocartPage AddPage = new AddtocartPage(driver);
		AddPage= LoPage.SelectBlouseAndChangeDetails();
	}

	@When("^Proceed checkout steps with bank wire payment option$")
	public void proceed_checkout_steps_with_bank_wire_payment_option() throws IOException, InterruptedException  {
		AddtocartPage AddPage = new AddtocartPage(driver);
		AddPage.AddtoCart();
	}

	@Then("^Assert this order in the history page$")
	public void assert_this_order_in_the_history_page() throws InterruptedException  {
		Thread.sleep(30);
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=history");
	}
	
	@After
	public void tearDown() {
    driver.close();
	}
	
}