package com.jon.easywebPage.studyCenter.courses;

import com.jon.easywebPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CourseListPage extends Page{

    @FindBy(className = "ui-table-inbox")
    WebElement tableList;

    public CourseListPage(WebDriver driver) {
        super(driver);
    }

    public int getListCount(){
        webDriver.navigate().refresh();
        String s = tableList.getTagName();
        WebElement e = webTools.findElement(tableList, By.tagName("tbody"));
        List<WebElement> lists = webTools.findElements(e,By.tagName("tr"));
        return lists == null ?0:lists.size();
    }
}
