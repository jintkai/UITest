package com.jon.easywebPage.login;

import com.jon.easywebPage.Page;
import com.jon.easywebPage.register.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class LoginPage extends Page {

    @FindBy(id = "iusername")
    WebElement userName;

    @FindBy(id = "iuserpwd")
    WebElement userPwd;

    @FindBy(name = "submit")
    WebElement submit;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
        openUrl("http://www.jd100.com/user/logon/?fromurl=http%3A%2F%2Fwww.jd100.com%2F");
    }

    public LoginPage(){

    }
    public void openUrl(String url){
        webTools.openUrl(url);
    }

    public void login(String username,String passwd){
        webTools.sendKeys(userName,username,true);
        webTools.sendKeys(userPwd,passwd,true);
        webTools.click(submit);

    }

    public void login(LoginDomain domain){
        webTools.sendKeys(userName,domain.getUserName(),true);
        webTools.sendKeys(userPwd,domain.getPasswd(),true);
        webTools.click(submit);
    }

    @Test
    public void testLogin(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/jon/Downloads/chromedriver");
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openUrl("http://www.jd100.com/user/logon/?fromurl=http%3A%2F%2Fwww.jd100.com%2F");
        loginPage.login(new LoginDomain("15116969680","123456"));
    }






}
