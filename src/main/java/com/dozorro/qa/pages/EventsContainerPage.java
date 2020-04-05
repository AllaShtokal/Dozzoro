package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventsContainerPage extends TestBase {

    //Page Factory -- object repository
    @FindBy(xpath = "//input[contains(@placeholder,'введіть назву запиту')]")
    WebElement nameOfSubscription;

    @FindBy(xpath = "//*[@id=\"subscribeSearchForm\"]/a[1]")
    WebElement saveSubscriptionBtn;

    @FindBy(xpath = "//a[contains(text(),'Закрити')]")
    WebElement closeBtn;


    @FindBy(xpath = "//label[@for=\"notify-subscribe\"]")
    WebElement selectSubscribe;

    //initializing the Page Objects:
    public EventsContainerPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void inputNameOfSubscription (String name)
    {
        nameOfSubscription.sendKeys(name);
    }
    public EventsContainerPage clickOnSaveSubscriptionBtn()
    {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOf(saveSubscriptionBtn));
        //wait.until(ExpectedConditions.elementToBeClickable(saveSubscriptionBtn));
        saveSubscriptionBtn.click();

        return new EventsContainerPage();
    }
    public MainPage clickcloseBtn(){
        closeBtn.click();
        return new MainPage();
    }
    public void checkCheckBox(){
        if(!selectSubscribe.isSelected())
            selectSubscribe.click();
    }
}
