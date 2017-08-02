package com.jon;

import com.jon.easywebPage.login.LoginDomain;
import com.jon.easywebPage.login.LoginPage;
import com.jon.easywebPage.studyCenter.courses.CoursePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CourseTest extends TestCase {
    public CourseTest(String node) {
        super("");
        coursePage = new CoursePage(driver);
    }
    CoursePage coursePage;

    @BeforeClass
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new LoginDomain("15116969680","123456"));
    }
    @Test
    public void testSelectCourseType(){
        coursePage.openUrl();
        coursePage.selectCourseType("学习卡课程");
        int count = coursePage.getLessonCount();
        System.out.println("...."+count);
        Assert.assertEquals(1,count,"学习卡课程数量验证");

        coursePage.selectCourseType("免费课程");
        count = coursePage.getLessonCount();
        Assert.assertEquals(6,count,"免费课程数量验证");

        coursePage.selectCourseType("正式课程");
        count = coursePage.getLessonCount();
        Assert.assertEquals(0,count,"正式课程数量验证");


    }
}
