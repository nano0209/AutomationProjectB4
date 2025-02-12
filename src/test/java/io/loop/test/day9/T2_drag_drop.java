package io.loop.test.day9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_drag_drop {

    /*
    1- Open a chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
     */

    @Test
    public void drag_drop_test() {
        Driver.getDriver().get(" https://demo.guru99.com/test/drag_drop.html");
        WebElement bank = Driver.getDriver().findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement debitAccount = Driver.getDriver().findElement(By.xpath("//ol[@id='bank']"));

        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(bank, debitAccount).perform();

        WebElement fivek = Driver.getDriver().findElement(By.xpath("//a[text() =' 5000 ']"));
        WebElement debitAmount =Driver.getDriver().findElement(By.id("amt7"));
        action.dragAndDrop(fivek, debitAmount).perform();

        WebElement sales = Driver.getDriver().findElement(By.xpath("//a[text() =' SALES ']"));
        WebElement creditAccount = Driver.getDriver().findElement(By.xpath("//ol[@id='loan']"));
        action.dragAndDrop(sales, creditAccount).perform();

        WebElement creditAmount =Driver.getDriver().findElement(By.id("amt8"));
        action.dragAndDrop(fivek, creditAmount).perform();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//a[contains(.,'Perfect')]"));
        String expected = "Perfect!";
        String actual = successMessage.getText();
        Assert.assertEquals(actual, expected, "Actual does not match the expected");
    }


}
