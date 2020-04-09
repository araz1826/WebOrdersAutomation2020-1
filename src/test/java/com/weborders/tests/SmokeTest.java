package com.weborders.tests;

import com.weborders.pages.LoginPage;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends AbstractBaseTest {

    @Test(dataProvider = "smokeTestData")
    public void smokeTest(String component, String expectedPageSubTitle) {
        extentTest = extentReports.createTest("Verify " + component);

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        loginPage.navigateTo(component);
        assertEquals(loginPage.getPageSubtitleText(), expectedPageSubTitle);

        extentTest.pass(component + " verified!");
    }
    //parallel is the branch name..  if you remove keyword below paralle, it will not run parallel, or if you put false it will not even run parallel
    @DataProvider (parallel = true)   // you tell parallel it means it runs tests parallel, to execute all test at the same time
    public Object[][] smokeTestData() {
        return new Object[][]{
                {"View all orders", "List of All Orders"},
                {"View all products", "List of Products"},
                {"Order", "Order"}
        };
    }
}
