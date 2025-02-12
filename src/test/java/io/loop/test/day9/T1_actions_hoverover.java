package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.security.Key;

public class T1_actions_hoverover {


    @Test
    public void google_actions_hover() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement fellingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(googleSearch).perform();
        Thread.sleep(300);
        actions.moveToElement(fellingLucky).perform();

        actions.sendKeys(Keys.F12).perform();
        actions.sendKeys(Keys.F5).perform();
        actions.doubleClick().perform();




    }
}
