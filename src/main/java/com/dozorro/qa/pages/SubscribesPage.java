package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscribesPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'Підписки за пошуком')]")
    WebElement subscriptionsBySearch;


    //initializing the Page Objects:

    public SubscribesPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions

    public void clickOnSubscriptionsBySearchSection(){
        subscriptionsBySearch.click();
    }

    public Boolean TryToFindNameOfSubscription(String mySubscriptionName) {
        if(driver.findElement(By.linkText(mySubscriptionName)).isDisplayed())
            return true;
        else return false;
    }
}
