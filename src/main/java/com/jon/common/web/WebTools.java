package com.jon.common.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTools {

    private WebDriver webDriver;
    public WebTools(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void openUrl(String url){
        webDriver.navigate().to(url);
    }

    /**
     *  输入值
     * @param element 需要输入的控件
     * @param content 输入的内容
     * @param isClear 输入前是否清空原有内容
     */
    public void sendKeys(WebElement element, String content, boolean isClear){
        if (isClear == true){
            element.clear();
        }
        element.sendKeys(content);
    }

    public void click(WebElement element){
        element.click();
    }

    public WebElement findElement(By by){
        return webDriver.findElement(by);
    }

    public WebElement findElement(WebElement element,By by){
        return element.findElement(by);
    }

    public String getHtml(){
        return webDriver.getPageSource();
    }
    public List<WebElement> findElements(WebElement element,By by){
        return element.findElements(by);
    }



}
