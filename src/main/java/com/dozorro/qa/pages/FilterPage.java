package com.dozorro.qa.pages;

import com.dozorro.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterPage extends TestBase {

    //Page Factory -- object repository
    @FindBy(xpath = "//*[@id=\"vue-indicators\"]/div[3]/div[2]/div/div[1]/div[15]/div[1]")
    WebElement methodRationaleItem;

    @FindBy(xpath = "//select[@name='rationale_like']")
    WebElement selectRationaleItem;

    @FindBy(xpath = "//button[@class='apply-btn']")
    WebElement applyBtn;


    //initializing the Page Objects:
    public FilterPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public FilterPage selectCategory(String category)
    {
        methodRationaleItem.click();
        return new FilterPage();

    }
    public FilterPage selectSubcategory(String subcategory)
    {
        Select dropdown = new Select(selectRationaleItem);
        dropdown.selectByValue(subcategory);
        return new FilterPage();
    }
    public SearchPage applyFiltering()
    {
        applyBtn.click();
        return new SearchPage();
    }



}
