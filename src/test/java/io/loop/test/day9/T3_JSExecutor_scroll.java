package io.loop.test.day9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class T3_JSExecutor_scroll {

    /*
    1. Go to https://www.etsy.com
    2. Scroll down
    3. Generate random email and enter into subscribe box
    4. Click on sign up
    5. Verify "you are in" is displayed
     */

    @Test
    public void nordstrom_scroll() {
        Driver.getDriver().get("https://www.nordstromrack.com/");
        WebElement box = Driver.getDriver().findElement(By.xpath("//input[@name='email-module-input']"));
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Sign up')]"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(box).click().perform();
    }

    @Test
    public void loopcamp_scroll() {
        Driver.getDriver().get("https://loopcamp.vercel.app/index.html");

        WebElement link = Driver.getDriver().findElement(By.xpath("//a[@href='https://www.loopcamp.io/']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(link).perform();

        //#2 use key press
       // actions.sendKeys(Keys.PAGE_DOWN, Keys.TAB).perform();

        //#3 move horizontally or vertically
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("window.scrollBy(0,5000)");

        //#4 scroll to view
        js.executeScript("arguments[0].scrollIntoView(true);", link);
        js.executeScript("arguments[0].click();", link);
        js.executeScript("window.scrollBy(0,5000)");


    }
}
