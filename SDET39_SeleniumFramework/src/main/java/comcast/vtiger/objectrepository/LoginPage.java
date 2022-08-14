package comcast.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement userPasswordTextfield;

	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUsernameTextfield() {
		return usernameTextfield;
	}

	public WebElement getUserPasswordTextfield() {
		return userPasswordTextfield;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Business logics
	/**
	 * this method is used for login to application
	 * @param username
	 * @param password
	 * @author Ankush
	 */
	public void login(String username, String password)
	{
		usernameTextfield.sendKeys(username);
		userPasswordTextfield.sendKeys(password);
		submitButton.click();
	}
	

	
	

}
