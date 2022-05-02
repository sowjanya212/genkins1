package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="password") public WebElement password;
    @FindBy(xpath="//span[text()='Next']/parent::button")public WebElement loginnext; 
    
    public LoginPage(RemoteWebDriver driver)
    {
       PageFactory.initElements(driver,this);
    }
    public void fillPassword(String x)
    {
    	password.sendKeys(x);
    }
    public void clickLoginNext() throws Exception
    {
    	loginnext.click();
    	Thread.sleep(5000);
    }
}
