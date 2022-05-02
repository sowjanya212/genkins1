package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(name="identifier") public WebElement username;
	@FindBy(xpath="//span[text()='Next']/parent::button")public WebElement homenext; 
public HomePage(RemoteWebDriver driver)
  {
	PageFactory.initElements(driver,this);
  }
 public void fillUserName(String X)
 {
	 username.sendKeys(X);
 }
 public void clickHomeNext() throws Exception
 {
	 homenext.click();
	 Thread.sleep(5000);
 }
}