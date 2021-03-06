package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(id="customer_firstname")
	WebElement Fname;
	
	@FindBy(id="customer_lastname")
	WebElement Lname;
	
	@FindBy(name="passwd")
	WebElement Pass;
	
	
	@FindBy(name="address1")
	WebElement Address;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(id="id_state")
	WebElement State;
	
	@FindBy(id="postcode")
	WebElement PostCode;
	
	@FindBy(id="phone_mobile")
	WebElement Phone;
	
	@FindBy(id="submitAccount")
	WebElement RegBtn;
	
	public LoginPage FillingForm(String FirstName,String LastName,String Password,String Add , String city,String ZipCode, String PhoneNum ) throws Exception {
		Fname.sendKeys(FirstName);
		Lname.sendKeys(LastName);
		Pass.sendKeys(Password);
		Address.sendKeys(Add);
		City.sendKeys(city);
		Select select = new Select(State);
		select.selectByVisibleText("Iowa");
		PostCode.sendKeys(ZipCode);
		Phone.sendKeys(PhoneNum);
		RegBtn.click();
		return new LoginPage(driver);
	}
}
