package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends TestBase {


    //Page Factory -- object repository
    @FindBy(xpath = "//input[@id='searchByTid']")
    WebElement searchField;
    @FindBy(xpath = "//button[contains(@class,'search-btn')]")
    WebElement searchBtn;
    @FindBy(xpath = "//button[contains(@class,'filter-modal-btn is-width-70-mobile')]")
    WebElement subscribeBtn;



    //initializing the Page Objects:
    public SearchPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions

    public void inputSearchKeyword(String keyword) {
        searchField.sendKeys(keyword);

    }
    public void clickOnSearchIconBtn(){
        searchBtn.click();
    }
    public EventsContainerPage clickOnSubscribeBtn(){
        subscribeBtn.click();
        return new EventsContainerPage();
    }

}
