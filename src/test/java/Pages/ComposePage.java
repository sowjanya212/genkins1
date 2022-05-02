package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposePage
{
   @FindBy(xpath="//div[text()='Compose']") public WebElement compose;
   @FindBy(name="to") public WebElement to;
   @FindBy(name="subjectbox") public WebElement subject;
   @FindBy(xpath="//div[@aria-label='Message Body']") public WebElement body;
   @FindBy(name="Filedata") public WebElement attachmentfile;
   @FindBy(xpath="//div[text()='Send']") public WebElement send;
   @FindBy(xpath="//div[@role='alert']/descendant::span[2]") public WebElement outputmsg;
   public ComposePage(RemoteWebDriver driver)
   {
	 PageFactory.initElements(driver,this);  
   }
   public boolean isDispalyed()
   {
	   if(compose.isDisplayed())
	   {
		   return(true);
	   }
	   else
	   {
		   return(false);
	   }
   }
   public void clickCompose() throws Exception
   {
	   compose.click();
	   Thread.sleep(5000);
   }
   public void fillTo(String x)
   {
	   to.sendKeys(x);
   }
   public void fillSubject(String x)
   {
	  subject.sendKeys(x); 
   }
   public void fillBody(String x)
   {
	   body.sendKeys(x);
   }
   public void fillFilepath(String x)
   {
	   attachmentfile.sendKeys(x);
   }
   public void send()
   {
	   send.click();
   }
   public String getOutputmsg()
   {
	   String x=outputmsg.getText();
	   return(x);
   }
   
}
