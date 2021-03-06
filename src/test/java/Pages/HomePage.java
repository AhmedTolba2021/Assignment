package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(className="login")
	WebElement loginBtn;
	
	@FindBy(id="email_create")
	WebElement EmailField;
	
	@FindBy(id="SubmitCreate")
	WebElement SubmitCreate;
	
	@FindBy(id="email")
	WebElement UserEmail;
	
	@FindBy(name="passwd")
	WebElement UserPass;
	
	@FindBy(id="SubmitLogin")
	WebElement LoginBtn;
	
	public RegistrationPage RegisterEmail(String EmailFieldText ) throws Exception {
		loginBtn.click();
		EmailField.sendKeys(EmailFieldText);
		SubmitCreate.click();
		return new RegistrationPage(driver);
	}

	public LoginPage Login(String Email,String Pass ) throws Exception {
		UserEmail.sendKeys(Email);
		UserPass.sendKeys(Pass);
		LoginBtn.click();
		return new LoginPage(driver);
	}
	public void SetUpChrome() {
		driver.get("http://automationpractice.com/index.php");
	}
}
