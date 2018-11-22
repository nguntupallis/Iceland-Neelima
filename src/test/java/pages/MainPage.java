package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
	
	
	public WebDriver driver;
	
	@FindBy(how = How.ID, using = "Shop Now | Online Food Shopping | Iceland Groceries")
	public WebElement title;
	
	@FindBy(how = How.ID, using = "searchText")
	public WebElement searchbox;
	
	@FindBy(how = How.ID, using = "search")
	public WebElement searchbutton;
	
   
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	

}
