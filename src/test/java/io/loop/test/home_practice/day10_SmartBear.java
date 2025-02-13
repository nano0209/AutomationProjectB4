package io.loop.test.home_practice;

import io.loop.pages.SmartBearPage;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day10_SmartBear {

  /*  1. Open browser
2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            3. Enter username: “Tester”
            4. Enter password: “test”
            5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
*/


    @BeforeMethod
    public void setUpMethod() {
        SmartBearPage smartBearPage = new SmartBearPage();
        Driver.getDriver().get(ConfigurationReader.getProperties("smartBearSoftware"));

    }

    @Test
    public void login_smartBear() {




    }

}
