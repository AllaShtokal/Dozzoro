package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

    //Page Factory -- object repository
    @FindBy(xpath = "//div[@class='login_link']")
    WebElement logInBtn;

    @FindBy(xpath = "//a[contains(@class,'btn btn-block btn-social btn-google')]")
    WebElement googleLogInBtn;

    @FindBy(xpath = "//div[@class='input-info']//a")
    WebElement advancedSearch;

    @FindBy(xpath = "//button[@class='dropdown-toggle']")
    WebElement userNameDropDown;

    @FindBy(xpath = "//a[text()='Сповіщення']")
    WebElement mySubscriptionsSelect;


    //initializing the Page Objects:

    public MainPage(){
      PageFactory.initElements(driver, this);
    }

    //Actions
    public void clickOnlogInBtn(){
        logInBtn.click();
    }
    //Нажать на кнопку входа с акк Google
    public GoogleLogInPage clickOnLogInWithGoogle(){
        googleLogInBtn.click();
        return new GoogleLogInPage();
    }
    //Нажать на кнопку Розширений пошук
    public FilterPage clickOnAdvancedSearch(){
        advancedSearch.click();
        return new FilterPage();
    }
    public void clickOnUserNameDropDown (){
        userNameDropDown.click();
    }
    public SubscribesPage selectMySubscribesPage(){
        mySubscriptionsSelect.click();
        return new SubscribesPage();
    }





}
