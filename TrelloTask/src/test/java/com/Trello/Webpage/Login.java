package com.Trello.Webpage;

import javax.swing.text.html.CSS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	private WebDriver driver;
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver=driver;
	}
	
	@FindBy(css = "a[class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")			WebElement login_button;
	
	@FindBy(css = "input#user")														WebElement emailId;
	@FindBy(id = "login")															WebElement click;
	@FindBy(id = "password")														WebElement pswd;
	@FindBy(id = "login-submit")													WebElement login;
	
	
	
	public BoardPage loginTrello(String email, String password) throws InterruptedException
	{
		login_button.click();
		emailId.sendKeys(email);
		click.click();
		Thread.sleep(2000);
		pswd.sendKeys(password);
		Thread.sleep(2000);
		login.click();
		return new BoardPage(driver);
	}
	
	
}
