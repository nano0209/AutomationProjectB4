package io.loop.pages;

import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearPage {

    public SmartBearPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$login_button']")
    public WebElement loginButton;



    public void loginSmartBear(String username, String password){
        BrowserUtils.waitForVisibility(userName, 5);
        userName.clear();
        userName.sendKeys(username);
      //  Password.clear();
      //  password.sendkey(password);
        BrowserUtils.waitForClickable(loginButton, 5);
        BrowserUtils.clickWithJS(loginButton);


    }
}