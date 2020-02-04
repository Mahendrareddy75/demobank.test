package demobank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver ldriver;
	public loginpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
@FindBy(name="uid")
@CacheLookup
WebElement textUserName;

@FindBy(name="password")
@CacheLookup
WebElement textPassword;

@FindBy(name="btnLogin")
@CacheLookup
WebElement btnLogin;

@FindBy(xpath="//a[contains(text(),'Log out')]")
@CacheLookup
WebElement lnklogin;

public void setUserName(String uname) {
	textUserName.sendKeys(uname);
}
public void setPassword(String password) {
	textPassword.sendKeys(password);
}
public void clicksubmit() {
	btnLogin.click();
}
public void clicklogout() {
	lnklogin.click();
}
}
