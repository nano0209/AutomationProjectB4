package io.loop.test.home_practice;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Extra_Task extends TestBase {

    @Test
    public void docuport() {
        driver.get("https://app.docuport.app/company-formation/resident");
        selectBusinessTypeOf("Corporation");


        //Validate Virginia is selected
        selectStateTypeOf("Virginia");

        // Validate Virginia Price Summary
        validateSummaryAndPrice("Virginia");
        selectStateTypeOf("Maryland");
        validateSummaryAndPrice("Maryland");

        //Validate order summer as below:
        WebElement orderSummery = driver.findElement(By.xpath("//h3[.=' Order summary ']"));

    }
    public void selectBusinessTypeOf(String business) {
        WebElement button1 = driver.findElement(By.xpath("//label[contains(text(),'" + business + "')]"));
        button1.click();
        WebElement button2 = driver.findElement(By.xpath("//label[contains(text(),'" + business + "')]/..//input"));
        System.out.println(button2.isSelected()+" Business type button selected is validated");

    }
    public void selectStateTypeOf(String state) {
        WebElement button1 = driver.findElement(By.xpath("//label[text()='"+state+"']"));
        button1.click();
        WebElement button2 = driver.findElement(By.xpath("//label[text()='"+state+"']/..//input"));
        System.out.println(button2.isSelected()+" State type button selected is validated");

    }
    public void validateSummaryAndPrice(String state) {
        List<WebElement> elements = driver.findElements(By.xpath("//p[contains(@class,'subtitle-2')]"));
        List<WebElement> elementsPrices = driver.findElements(By.xpath("//p[contains(@class,'text-right body-2')]"));
        Map<String, String> actualMap = new LinkedHashMap<>();

        Map<String, String> expectedMap = new LinkedHashMap<>();

        if (state.equals("Virginia")) {
            expectedMap.put("State registration fee", "$50");
            expectedMap.put("Payment processing", "$3");
            expectedMap.put("Service fee", "$150");
            expectedMap.put("Total", "$203");
        } else if (state.equals("Maryland")) {
            expectedMap.put("State registration fee", "$170");
            expectedMap.put("Payment processing", "$10.20");
            expectedMap.put("Service fee", "$150");
            expectedMap.put("Total", "$330.20");
        }
        for (int i = 0; i < elements.size(); i++) {
            actualMap.put(elements.get(i).getText(), elementsPrices.get(i).getText());
        }
        for (String each : actualMap.keySet()) {
            System.out.println(each + " " + actualMap.get(each));
        }
        if (expectedMap.equals(actualMap)) {
            System.out.println("True");
        }
        Assert.assertEquals(actualMap,expectedMap);

    }

}
