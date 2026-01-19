package kbm.qa.pages;


import kbm.qa.utils.BasePage;
import kbm.qa.utils.Log;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	private BasePage basePage;
	
	// private By locators:
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("submit");
    private By successMsg = By.cssSelector(".post-title");
    private By errorMsg = By.id("error");

    // constructors
    public LoginPage() {
		basePage = new BasePage();
	}
    
    // public Page actions (methods)
    public void login(String username, String password) {
    	
    	type(this.username, username);
        type(this.password, password);
        
    	Log.info("Clicking Login button");
    	click(loginBtn);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
    
    public String getLoginPageTitle() {
       	return basePage.getPageTitle();
    }
    
    public String getLoginPageURL() {
       	return basePage.getPageURL();
    }
    
 // Validations
    public String getErrorMessage() {
        return getText(errorMsg);
    }

    public boolean isErrorDisplayed() {
        return driver.findElements(errorMsg).size() > 0;
    }
}


