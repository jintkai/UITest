package com.jon.easywebPage.studyCenter.active;

import com.jon.easywebPage.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivePage extends Page{

    @FindBy(id = "J_activeCode")
    private WebElement activeCode;
    @FindBy(id = "validCode")
    private WebElement validCode;
    @FindBy(id = "J_validCodeImg")
    private WebElement validCodeImg;
    @FindBy(id = "J_submitActive")
    private WebElement submitActive;

    public void active(String code){
        webTools.sendKeys(activeCode,code,true);
        webTools.click(submitActive);
    }
}
