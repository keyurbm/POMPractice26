package kbm.qa.base;

import kbm.qa.driver.DriverFactory;
import kbm.qa.utils.ConfigReader;
import kbm.qa.utils.Log;

import java.util.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected Properties prop;
    ConfigReader ConfigReader;

    @BeforeMethod
    public void setup() {

    	ConfigReader = new ConfigReader();
    	prop = ConfigReader.initProperties();

    	Log.info("Launching Chrome browser");
    	
    	DriverFactory.initDriver(prop.getProperty("browser"));
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        Log.info("Closing browser");
    	DriverFactory.quitDriver();
    }
}




