package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //navigate to loopcamp

        driver.get("https://loopcamp.vercel.app/registration_form.html");
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Loop");

       // WebElement withClassName = driver.findElement(By.className("form-control"));
        // withClassName.sendKeys("Loop");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Camp");

        WebElement female = driver.findElement(By.name("gender"));
        female.click();
    }
}
