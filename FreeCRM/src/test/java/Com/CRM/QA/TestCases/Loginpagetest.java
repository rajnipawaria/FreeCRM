package Com.CRM.QA.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.CRM.QA.Base.Testbase;
import Com.CRM.QA.Pages.Homepage;
import Com.CRM.QA.Pages.Loginpage;

public class Loginpagetest extends Testbase
{
	public Loginpage loginpage;
	public Homepage homepage;
public Loginpagetest()
{
	super();

}

	@BeforeMethod
	public void setup()
	{
		 
		initialization();	
		 loginpage=new Loginpage();
	}
	
@Test
public void loginpagetitletest()
{
	
String title=loginpage.Validateloginpagetitle();
Assert.assertEquals(title, "Free CRM login page");
}

@Test
public void Crmlogoimagetest()
{
	Boolean flag=loginpage.ValidateImage();
	Assert.assertTrue(flag);
	}

@Test
public void logintest()
{
	homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

@AfterMethod
public void Teardown()
{
	}
}
