package com.Trello.Webpage;

import java.awt.event.ActionEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoardPage {
	
	WebDriver driver;
	
	public BoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	Actions a;
	
	@FindBy(xpath = "//button[@aria-label='Create board or Workspace']")			WebElement create;
	@FindBy(css = "button[data-testid='header-create-board-button']")				WebElement creatBoard;
	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")				WebElement boardname;
	@FindBy(xpath = "//button[@data-testid='create-board-submit-button']")			WebElement create1;

	public void createBoard() throws InterruptedException
	{
		Thread.sleep(2000);
		create.click();
		creatBoard.click();
		boardname.sendKeys("Board1");
		create1.click();
		
	}
	
	
	
	@FindBy(css = "span[class='placeholder']")									WebElement addList;
	@FindBy(css = "input[placeholder='Enter list title…']")						WebElement createlisst1;
	@FindBy(css = "input[value='Add list']")									WebElement clickOnaddList;
	
	
	public void creat_lists() throws InterruptedException
	{
//		addList.click();
		Thread.sleep(2000);
		createlisst1.sendKeys("List_A");
		createlisst1.sendKeys(Keys.ENTER);

		createlisst1.sendKeys("List_B");
		createlisst1.sendKeys(Keys.ENTER);
		
	}
	
	
	@FindBy(css = "a[class='open-card-composer js-open-card-composer']")			WebElement addCard;
	@FindBy(css = "textarea[placeholder='Enter a title for this card…']")			WebElement enterCardname;
	
	
	@FindBy(xpath = "//div[@id='board']/child ::div[1]/child ::div/child ::div[2]/child ::a")				WebElement source;
	@FindBy(xpath="//textarea[@aria-label='List_B']")														WebElement target;
	@FindBy(xpath="/html/body/div[6]/div/section/div/div/ul[3]/li[2]/button")								WebElement logout;
	public void addCards() throws InterruptedException
	{
		addCard.click();
		enterCardname.sendKeys("Card_1");
		enterCardname.sendKeys(Keys.ENTER);
		System.out.println("X co-ordinates of source= "+source.getLocation().getX());
		System.out.println("Y co-ordinates of source= "+target.getLocation().getY());
		
		
		Thread.sleep(2000);
		a=new Actions(driver);
		a.dragAndDrop(source, target).clickAndHold().pause(1000).release().perform();
		logout.click();

	}
	
	
	
	
	
	

}
