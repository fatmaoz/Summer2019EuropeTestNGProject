package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
//you need sthing
    @Test
    public void verifySubTitleTest() {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashBoardPage dashboardPage = new DashBoardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();
       // Assert.assertEquals(actualSubtitle,expectedSubtitle);

        Assert.assertEquals(dashboardPage.getPageSubTitle(),"Quick Launchpad");

        dashboardPage.navigateToModule("Avtivities","Calender Events");

        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        Assert.assertEquals(calenderEventsPage.getPageSubTitle(),"Calender Events","Verify subtitle");

    }

}
