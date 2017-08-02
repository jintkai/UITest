package com.jon.easywebPage.studyCenter.courses;

import com.jon.easywebPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseTabPage extends Page {

    @FindBy(className = "ui-tab-items")
    private WebElement tabItems;

    public CourseTabPage(WebDriver driver) {
        super(driver);
    }

    public void tabClick(String tabName){
        WebElement tab = webTools.findElement(tabItems, By.linkText(tabName));
        webTools.click(tab);
    }

}
