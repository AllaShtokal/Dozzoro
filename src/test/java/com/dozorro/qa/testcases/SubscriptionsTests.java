package com.dozorro.qa.testcases;

import com.dozorro.qa.pages.*;
import com.dozorro.qa.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubscriptionsTests extends TestBase {
    MainPage mainPage;
    GoogleLogInPage googleLogInPage;
    FilterPage filterPage;
    SearchPage searchPage;
    EventsContainerPage eventsContainerPage;
    SubscribesPage subscribesPage;
    public SubscriptionsTests(){
        super();//to call TestBase constructor (to init Properties)
    }

    public void setUp(){
        initialization();
        mainPage = new MainPage();
        googleLogInPage = new GoogleLogInPage();
        filterPage = new FilterPage();
        eventsContainerPage = new EventsContainerPage();
        subscribesPage = new SubscribesPage();
    }
    @BeforeGroups("User is authorized")
    public void preconditionlogIn()
    {
        setUp();
        //pre-conditions
        //вход в аккаунт
        mainPage.clickOnlogInBtn();
        //перешли на вход в гугл
        googleLogInPage = mainPage.clickOnLogInWithGoogle();
        //вводим логин и пароль
        googleLogInPage.inputEmail("YourGoogleLogin");
        googleLogInPage = googleLogInPage.clickFirstNextBtn();
        googleLogInPage.inputPassword("YourPass");
        mainPage = googleLogInPage.clickSecondNextBtn();
    }
    @Test(priority = 1,groups= {"User is authorized"})
    public void newSubscriptionDisplayingBySearchKeywordTest() throws InterruptedException {
        //перешли в Розширений пошук
         filterPage = mainPage.clickOnAdvancedSearch();
        filterPage = filterPage.selectCategory("Обгрунтування методу");
        filterPage = filterPage.selectSubcategory("COVID");
         searchPage = filterPage.applyFiltering();
         searchPage.inputSearchKeyword("маски");
         searchPage.clickOnSearchIconBtn();
         eventsContainerPage=searchPage.clickOnSubscribeBtn();
         eventsContainerPage.inputNameOfSubscription("моя новая подписка Маски");
         //eventsContainerPage.checkCheckBox();
        eventsContainerPage = eventsContainerPage.clickOnSaveSubscriptionBtn();
         mainPage = eventsContainerPage.clickcloseBtn();
         mainPage.clickOnUserNameDropDown();
         subscribesPage = mainPage.selectMySubscribesPage();
         subscribesPage.clickOnSubscriptionsBySearchSection();
         Assert.assertTrue(subscribesPage.TryToFindNameOfSubscription("моя новая подписка Маски"),"Подпискс не добавлена");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
