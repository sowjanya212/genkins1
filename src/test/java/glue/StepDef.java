package glue;

import java.util.List;
import java.util.Map;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Pages.ComposePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef
{
   public RemoteWebDriver driver;
   public HomePage obj1;
   public LoginPage obj2;
   public ComposePage obj3;
   public LogoutPage obj4;
   @Given("open {string} browser")
   public void method1(String bn)
   {
	  if(bn.equalsIgnoreCase("edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		  obj1=new HomePage(driver);
		  obj2=new LoginPage(driver);
		  obj3=new ComposePage(driver);
		  obj4=new LogoutPage(driver);
		}
	  }
   @Given("launch site using {string}")
   public void method2(String url) throws Exception
   {
	  driver.get(url); 
	  Thread.sleep(5000);
   }
   @When("do login using {string} and {string} credentials")
   public void method3(String un,String pwd) throws Exception
   {
	  obj1.fillUserName(un);
	  obj1.clickHomeNext();
	  obj2.fillPassword(pwd);
	  obj2.clickLoginNext();
   }
   @Then("compose is displayed")
   public void method4()
   {
	  if(obj3.isDispalyed())
	  {
		  System.out.println("compose is displayed");
	  }
	  else
	  {
		  System.out.println("compose is not displayed");
		  System.exit(0);
	  }
   }
   @When("click on compose and fill feilds and send mail and check response")
   public void method5(DataTable dt) throws Exception
   {
	   List<Map<String,String>> l=dt.asMaps();
	   for(int i=0;i<l.size();i++)
	   {
		  obj3.clickCompose();
		  obj3.fillTo(l.get(i).get("to"));
		  obj3.fillSubject(l.get(i).get("subject"));
		  obj3.fillBody(l.get(i).get("body"));
		  obj3.fillFilepath(l.get(i).get("attachment"));
		  obj3.send();
		  System.out.println(obj3.getOutputmsg());
		  Thread.sleep(10000);
	   }
 }
   @When("do logout") 
   public void method6() throws Exception
   {
	   obj4.clickProfilepic(driver);
	   obj4.clickSignout(driver);
	   Thread.sleep(15000);
   }
   
   @Then("login page should be redisplayed")
   public void method7()
   {
	  if( obj4.isLoginredispalyed())
	  {
		  System.out.println("successful logout");
	  }
	  else
	  {
		  System.out.println("unsuccessful logout");
	  }
   }
   @When("close site")
   public void method8()
   {
	   driver.close();
   }
}
