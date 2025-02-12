package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.PizzaOrderWebTableUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.loop.test.utilities.Driver.getDriver;
import static org.testng.Assert.assertEquals;

public class T0_pizza_order extends TestBase {




    @Test
    public void test_pizza_type(){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Alexandra Gray";
        String expectedPizzaType = "Thin Crust";
        String actualPizzaType = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "pizza type");

        assertEquals(actualPizzaType, expectedPizzaType, "Actual does not match expected");
    }


    @Test
    public void test_amount(){
        String name = "John Doe";
        String expectedAccount = "3";
        String actualAccount = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "account");
        assertEquals(actualAccount, expectedAccount, "Actual does not match");

    }
    @Test
    public void test_date(){
        //String name = "Bob Martin";
        String expectedDate = "12/31/2021";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(),"Bob Martin", "Date" ), expectedDate);

    }

    @Test
    public void test_street(){
        //String name = "Robert Baratheon";
        String expectedStreet = "29, Sanderson Ave";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(),"Robert Baratheon", "Street"),expectedStreet);

    }

    @Test
    public void test_city(){
        //String name = "Ned Stark";
        String expectedCity = "Newcastle";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(), "Ned Stark", "City" ), expectedCity);


    }

    @Test
    public void test_state(){
        // String name = "Stewart Dawidson";
        String expectedState = "Canada";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(),"Stewart Dawidson", "State"),expectedState);

    }

    @Test
    public void test_zip(){
        //String name = "Samuel Jackson";
        String expectedZip = "53665";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(), "Samuel Jackson", "Zip"),expectedZip);

    }

    @Test
    public void test_card(){
        //String name = "Robert Baratheon";
        String expectedCard = "MasterCard";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(),"Robert Baratheon", "Card"),expectedCard);

    }

    @Test
    public void test_card_number(){
        //String name = "Alexandra Gray";
        String expectedCardNumber = "321456789012";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(), "Alexandra Gray", "Card Number"),expectedCardNumber);

    }

    @Test
    public void test_exp(){
        //String name = "John Doe";
        String expectedExp = "01/23";
        assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(getDriver(), "John Doe", "Exp" ),expectedExp);

    }



}
