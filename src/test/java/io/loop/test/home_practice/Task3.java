package io.loop.test.home_practice;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class Task3 extends TestBase {
    @Test
    public void validateTextNewWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement newWindowMessageLink = driver.findElement(By.xpath("//button[normalize-space(text())='New Window Message']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", newWindowMessageLink);

        String originalWindow = driver.getWindowHandle();
        newWindowMessageLink.click();

        Thread.sleep(2000);

        Set<String> windows = driver.getWindowHandles();

        String currentWindow = driver.getWindowHandle();

        for (String each : windows) {
            if(!each.equals(currentWindow)){
                driver.switchTo().window(each);
            }
            // System.out.println(each);
        }


        WebElement messageElement = driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]"));
        String actualMessage = messageElement.getText();
        String expectedMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        Assert.assertEquals(actualMessage, expectedMessage, "Text does not match!");

        driver.close();
        driver.switchTo().window(originalWindow);


    }
}
