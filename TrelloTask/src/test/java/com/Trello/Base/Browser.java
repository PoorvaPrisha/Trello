package com.Trello.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	
	protected WebDriver driver;
	public Properties pr;
	FileInputStream fi;
	String path="D:\\Testing_automation\\TrelloTask\\src\\test\\resources\\Configuration\\config.properties";
	
	public Browser()
	{
		
		try {
			 fi=new FileInputStream(path);
			pr=new Properties();
			try {
				pr.load(fi);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pr.getProperty("url"));
		
		return driver;
	}
}
