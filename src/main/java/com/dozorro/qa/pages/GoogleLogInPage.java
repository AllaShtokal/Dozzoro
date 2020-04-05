package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleLogInPage extends TestBase {

    //Page Factory -- object repository
    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement passField;

    @FindBy(id = "identifierNext")
    WebElement firstNextBtn;

    @FindBy(id = "passwordNext")
    WebElement secondNextBtn;

    //initializing the Page Objects:
    public GoogleLogInPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void inputEmail (String email)
    {
        emailField.sendKeys(email);

    }
    public GoogleLogInPage clickFirstNextBtn()
    {
        firstNextBtn.click();
        return new GoogleLogInPage();
    }
    public MainPage clickSecondNextBtn()
    {
        secondNextBtn.click();
        return new MainPage();

    }

    public void inputPassword(String pass)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(passField));
        wait.until(ExpectedConditions.elementToBeClickable(passField));
        passField.sendKeys(pass);

    }
}
