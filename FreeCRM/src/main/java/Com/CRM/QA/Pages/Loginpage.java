package Com.CRM.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.CRM.QA.Base.Testbase;
//We have to define the page factory or object repository for this class
public class Loginpage extends Testbase
{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//imput[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text()),'Sign Up']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[contains(@class,'log-responsive-responsive')]")
	WebElement crmlogo;
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}

public String Validateloginpagetitle()
{
	return driver.getTitle();
	
}

public boolean ValidateImage()
{
	
return crmlogo.isDisplayed();

}

public Homepage Login(String usr, String pwd)
{
	
username.sendKeys(usr);
password.sendKeys(pwd);
loginbtn.click();
return new Homepage();
}


}
