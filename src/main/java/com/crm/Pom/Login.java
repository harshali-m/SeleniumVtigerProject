package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(xpath = "//input[@type='text']")
	WebElement username;
	public WebElement userName()
	{
		return username;
	}
	public void firstName(String userName)
	{
		username.sendKeys(userName);
	}
	private @FindBy(xpath = "//input[@type='password']")
	WebElement password ;
	public WebElement password()
	{
		return password;
	}
	public void pass(String Password)
	{
		password.sendKeys(Password);
	}
	private @FindBy(id = "submitButton")
	WebElement loginButton ;
	public void login()
	{
		loginButton.click();
	}
	private @FindBy(xpath = "//a[contains(text(), 'Sign Out')]")
	WebElement signOut;
	public void signOut()
	{
		signOut.click();
	}
}
