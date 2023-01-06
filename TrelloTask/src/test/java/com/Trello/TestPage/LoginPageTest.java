package com.Trello.TestPage;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Trello.Base.Browser;
import com.Trello.Webpage.Login;

public class LoginPageTest extends Browser {
	
	WebDriver driver;
	Login lgObj;
	
	
	@BeforeClass
	public void browserInit()
	{
		driver=openBrowser();
		lgObj=new Login(driver);
	}
	
	
	@Test
	public void loginPage()
	{
		try {
			lgObj.loginTrello(pr.getProperty("loginID"), pr.getProperty("pswd"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
