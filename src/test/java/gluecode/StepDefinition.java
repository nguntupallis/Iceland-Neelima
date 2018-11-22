package gluecode;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.MainPage;

public class StepDefinition {
	
	static WebDriver driver;
	static String[] SearchSuggestion;
	static String SuggestedProduct;
	static WebElement FirstSearchSuggestion;
	static String SearchTermtoLookFor;
	MainPage mpage;
	
	@BeforeClass
	public void before()
	{
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		 driver = new ChromeDriver();
	}
	

	@Given("^I want to launch Iceland Grocery page with Chrome Browser$")
	public void i_want_to_launch_Iceland_Grocery_page_with_Chrome_Browser() throws Throwable {
	   driver = new ChromeDriver();
	}

	@Given("^I enter the url \"([^\"]*)\" as input$")
	public void i_enter_the_url_as_input(String u) throws Throwable {
		driver.get(u);
	 
	}

	@Then("^I am able to see the Iceland Groceries page \"([^\"]*)\"$")
	public void i_am_able_to_see_the_Iceland_Groceries_page(String t) throws Throwable {
		
		//driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		String pagetitle = driver.getTitle();
		if (pagetitle == t)
		{
			System.out.println("Page is loaded successfully");
		}
	}
	
	@Given("^I type \"([^\"]*)\" in the searchbox$")
	public void i_type_in_the_searchbox(String arg1) throws Throwable {
		

		mpage = new MainPage(driver);

		mpage.searchbox.clear();
		mpage.searchbox.sendKeys(arg1);	
		
	}


	@Then("^The suggested groceries should contain the \"([^\"]*)\"$")
	public void the_suggested_groceries_should_contain_the(String arg1) throws Throwable {
		 
		Thread.sleep(1000);
		
		WebElement SearchSuggestionsElement;
		
		try
		{		
		SearchSuggestionsElement = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search Suggestions'])[1]/following::ul[1]"));
		}
		
		catch (NoSuchElementException e)
		{
			System.out.println("Slider not found");
			SearchSuggestionsElement = driver.findElement(By.xpath("//*[@id=\"autocompleteDiv\"]/ul/li[1]"));
			
		}
		
		 String SearchSuggestions = SearchSuggestionsElement.getText();
  	   
		  SearchSuggestion = SearchSuggestions.split("\n");
		  
		  for (int i =0; i<SearchSuggestion.length; i++)
		  {
			 SuggestedProduct = SearchSuggestion[i];
			 Assert.assertTrue(SuggestedProduct.contains(arg1));
			 
		  }
	}
	
	@Given("^I select \"([^\"]*)\" from the suggestions displayed$")
	public void i_select_from_the_suggestions_displayed(String arg1) throws Throwable {
		
		String SecondProduct = SearchSuggestion[1].toString();
		
		WebElement Producttoselect = driver.findElement(By.linkText(SecondProduct));
		
		Actions action = new Actions(driver);
		action.moveToElement(Producttoselect);


	}


	@Then("^The displayed groceries should contain the \"([^\"]*)\"$")
	public void the_displayed_groceries_should_contain_the(String arg1) throws Throwable {

	 String SecondProduct = SearchSuggestion[1].toString();
	 
		WebElement Producttoselect = driver.findElement(By.linkText(SecondProduct));
		
		//Actions action = new Actions(driver);
		//action.moveToElement(Producttoselect);
		Producttoselect.click();
	 
	 String[] SecondProductwords = SecondProduct.split(" ");
	 
     String QualityStreetProductdetails;
     
		try
		{
		
			QualityStreetProductdetails = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quality Street Tub 720g'])[1]/following::div[1]")).getText();
		}
		
		catch (NoSuchElementException e)
		{
			System.out.println("Slider not found");
			QualityStreetProductdetails = driver.findElement(By.linkText("Quality Street Tub 720g")).getText();
			
		}
        
     for (String word : SecondProductwords)
	 if (QualityStreetProductdetails.contains(word))
	 {
		 System.out.println("Product matches the search suggestion");
	 }
     
	}
	
	@AfterClass
	public void After()
	{
		driver.close();
		driver.quit();
		
	}
}
