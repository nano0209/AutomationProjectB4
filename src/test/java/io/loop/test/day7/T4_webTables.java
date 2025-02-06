package io.loop.test.day7;

import io.loop.test.DocuportConstants;
import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T4_webTables extends TestBase {
   /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

    @Test
    public void test_webTables() throws InterruptedException {

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement user = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        user.click();

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        assertEquals(actualFullName, expectedFullName, "Actual does not match expected");

        System.out.println("Actual full name is: " + actualFullName);

        String actualUserName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "User Name");
        String expectedUserName = "alexdesouze";
        System.out.println("User name:" + actualUserName);
        Assert.assertEquals(actualUserName, expectedUserName);

        String actualUserPhoneNumber = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Phone Number");
        String expectedUserPhoneNumber = "+994512060042" ;
        System.out.println("Phone number: " + actualUserPhoneNumber);
        Assert.assertEquals(actualUserPhoneNumber, expectedUserPhoneNumber);

        String actualUserNameRole = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Role");
        String expectedUserNameRole = "Client";
        System.out.println("Role: " + actualUserNameRole);
        Assert.assertEquals(actualUserNameRole, expectedUserNameRole);

        String actualUserAdvisor = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Advisor");
        String expectedUserAdvisor = "Batch1 Group1";
        System.out.println("Advisor: " + actualUserAdvisor);
        Assert.assertEquals(actualUserAdvisor, expectedUserAdvisor);
    }
}
