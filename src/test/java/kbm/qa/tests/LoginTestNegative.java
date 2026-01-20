package kbm.qa.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kbm.qa.pages.LoginPage;

public class LoginTestNegative {
	
	private LoginPage loginPage;
	
	//TestNG Data Provider test
    @DataProvider(name="loginData")
    public Object[][] getLoginData(){
    	return new Object[][] {
    		// username, password
    		{"wrongUser", "wrongPass"},
    		{"student", "Password123"},
        };
    }
    
    @Test(dataProvider = "loginData",enabled=false)
    public void loginDataProviderTest(String user, String pass) {
    	loginPage.login(user, pass);
    }
}
