package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {
    //Page Factory -- object repository
    @FindBy(xpath = "//input[contains(@placeholder,'введіть назву запиту')]")
    WebElement nameOfSubscription;

    //initializing the Page Objects:
    public AccountPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions

}
