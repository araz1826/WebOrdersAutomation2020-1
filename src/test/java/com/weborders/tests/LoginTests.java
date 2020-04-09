package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.Driver;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;

public class LoginTests extends AbstractBaseTest {

    @Test
    public void login(){
        extentTest = extentReports.createTest("Verify page logo");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        assertEquals(loginPage.getPageLogoText(), "Web Orders");

        extentTest.pass("Logo verified!");
    }

    /**
     * This method will switch webdriver from current window
     * to target window based on page title
     *
     * @param title of the window to switch
     */
    public static void switchWindow(String title) {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String window : windowHandles) {
            Driver.getDriver().switchTo().window(window);
            if (Driver.getDriver().getTitle().equals(title)) {
                break;
            }
        }
    }}