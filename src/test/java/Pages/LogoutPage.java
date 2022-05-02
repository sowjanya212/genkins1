package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
	@FindBy(xpath="//a[starts-with(@aria-label,'Google Account')]/img") public WebElement profilepic;
	@FindBy(xpath="//*[text()='Sign out']/parent::a") public WebElement signout;
	@FindBy(xpath="//span[text()='Choose an account']") public WebElement relogin;
	
	
   public LogoutPage(RemoteWebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   
  public void clickProfilepic() throws Exception
  {
	  profilepic.click();
	  Thread.sleep(10000);
  }
  
   public void clickSignout(RemoteWebDriver driver) throws Exception
   {
	   try
	   
	   {
		   WebElement e= driver.findElement(By.xpath("//iframe[@role='presentation'])[2]"));
	    	driver.switchTo().frame(e);
		   signout.click();
		   Thread.sleep(10000);
		}
	   catch(Exception ex)
	   {
		   System.out.println("false ");
	   }
   }
 public boolean isLoginredispalyed()
   {
	   if(relogin.isDisplayed())
	   {
		   return(true);
	   }
	   else
	   {
		   return(false);
	   }
   
   }
}
