package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class T2_new_methods_window extends TestBase {

    @Test
    public void test_new_methods() {

        driver.get("http//google.com");

        //open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://loopcamp.io");

        //open a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://amazon.com");

    }

    }

