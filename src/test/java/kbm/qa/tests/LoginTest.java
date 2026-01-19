package kbm.qa.tests;

import kbm.qa.base.BaseTest;
import kbm.qa.pages.LoginPage;
import kbm.qa.utils.ExcelUtil;
import kbm.qa.utils.Log;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(); // ✅ created once per test
    }
	
	@Test
    public void loginPageTitleTest() {
        
		Log.info("===== Login Title Test =====");
		
		String title = loginPage.getPageTitle();
        System.out.println("login page title is: " + title);
        Assert.assertEquals(title,"Test Login | Practice Test Automation","Page title is incorrect");
    }

    @Test
    public void loginPageURLTest() {
    	
    	Log.info("===== Login URL Test =====");
    	
    	String url = loginPage.getLoginPageURL();
    	System.out.println("login page URL is: " + url);
    	Assert.assertEquals(url,"https://practicetestautomation.com/practice-test-login/","Page URL is incorrect");
    }
    
    @Test(enabled = true)
    public void validLoginTest() {
        loginPage.login(prop.get("username").toString(), prop.get("password").toString());
        Assert.assertEquals(loginPage.getSuccessMessage(),"Logged In Successfully","Login success message mismatch");
    }
    
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
    
    //Data driven - Excel data test
    @DataProvider(name = "loginExcelData")
    public Object[][] getLoginExcelData() {
        return ExcelUtil.getTestData("LoginData");
    }
    
    @Test(dataProvider = "loginExcelData",enabled=false)
    public void loginTest(String username,String password,String expectedResult) {

        loginPage.login(username, password);

        if (expectedResult.equalsIgnoreCase("success")) {
        	Assert.assertEquals(loginPage.getSuccessMessage(),"Logged In Successfully");

        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed(),"Error message not displayed for invalid login");
        }
    }
}

