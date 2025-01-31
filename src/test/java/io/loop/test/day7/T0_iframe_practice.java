package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;

public class T0_iframe_practice extends TestBase {
       /*
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

     */

    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();
        assertEquals(actualLeft.trim(),"LEFT");

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        String actualMiddle = middle.getText();
        assertEquals(actualMiddle.trim(),"MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        String actualRight = right.getText();
        assertEquals(actualRight.trim(),"RIGHT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        String actualBottom = bottom.getText();
        assertEquals(actualBottom.trim(), "BOTTOM");


        }


}

