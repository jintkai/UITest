package com.jon.easywebPage;

import com.jon.common.web.EventListener;
import com.jon.common.web.WebTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Page {

    protected WebDriver webDriver;
    protected WebTools webTools;

    public Page(WebDriver driver){
        System.setProperty("webdriver.chrome.driver","/Users/jon/Downloads/chromedriver");

        webDriver=new EventFiringWebDriver(driver).register(new EventListener());

        webTools = new WebTools(webDriver);
        PageFactory.initElements(webDriver,this);

    }

    public Page() {
        System.out.println("Page");
    }
}
