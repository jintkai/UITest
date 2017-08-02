package com.jon;

import com.jon.easywebPage.login.LoginDomain;
import com.jon.easywebPage.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestCase {

    private LoginPage loginPage;

    public LoginTest(String node) {
        super("");
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin(){
        LoginDomain loginDomain = new LoginDomain("15116969680","123456");
        loginPage.login(loginDomain);
        WebElement element = webTools.findElement(By.linkText("个人中心"));
        Assert.assertNotNull(element,"'个人中心'文本框不存在，判断登录失败");
    }

}
