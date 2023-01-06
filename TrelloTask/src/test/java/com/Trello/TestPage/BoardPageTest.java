package com.Trello.TestPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Trello.Base.Browser;
import com.Trello.Webpage.BoardPage;
import com.Trello.Webpage.Login;

public class BoardPageTest extends Browser{
	
	private WebDriver driver;
	Login lgObj;
	BoardPage boardObj;
	
	@BeforeClass
	public void openBro()
	{
		driver=openBrowser();
		lgObj=new Login(driver);
		
	}
	
	@BeforeMethod
	public void applyWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void loginPage()
	{
		try {
			 boardObj = lgObj.loginTrello(pr.getProperty("loginID"), pr.getProperty("pswd"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void createBoard() throws InterruptedException
	{
		boardObj.createBoard();
		boardObj.creat_lists();
		boardObj.addCards();
		
	}
	
	
	

}
