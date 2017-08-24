package com.jon;

import com.jon.common.Tools;
import com.jon.easywebPage.common.GradeDomain;
import com.jon.easywebPage.register.RegisterDomain;
import com.jon.easywebPage.register.RegisterPage;
import com.jon.easywebPage.school.SchoolDomain;
import org.testng.annotations.Test;

public class RegisterTest extends TestCase {
    public RegisterTest(String node) {
        super("");
        registerPage = new RegisterPage(driver);
    }

    RegisterPage registerPage;

    @Test
    public void testRegister(){
        String userName = "selenium"+Tools.getRandomNumber();
        String mobile = "17000000000";
        RegisterDomain domain = new RegisterDomain(userName,"123456",
                "700000000","学生","测试人员",mobile,
                new SchoolDomain("西藏","山南","乃东县","山南地区高级中学"),
                new GradeDomain("高中","2016年高中入学"));
        registerPage.register(domain);


    }

}
