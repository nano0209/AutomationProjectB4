package io.loop.test.home_practice;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1_Google {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement gmailSign = driver.findElement(By.linkText("Gmail"));
        gmailSign.click();
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)) {
            System.out.println("Title Match");
        }else {
            System.out.println("Title Not Match");
        }
        driver.navigate().back();
        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();

        if(actualTitle2.contains(expectedTitle2)) {
            System.out.println("Title Match");
        }else {
            System.out.println("Title Not Match");
        }

    }
}
