package com.jon.page.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "iusername")
    WebElement userName;

    @FindBy(id = "iuserpwd")
    WebElement userPwd;

    public void login(String username,String passwd){
        userName.sendKeys(username);
        userPwd.sendKeys(passwd);
        userName.submit();
    }


}
