package kbm.qa.utils;

import kbm.qa.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* 
 * BasePage – Common Utilities 
 * */
public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    protected void type(By locator, String value) {
    	driver.findElement(locator).clear();
    	driver.findElement(locator).sendKeys(value);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public String getPageURL() {
    	return driver.getCurrentUrl();
    }
}

