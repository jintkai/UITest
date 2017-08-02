package com.jon.easywebPage.studyCenter.courses;

import com.jon.easywebPage.Page;
import org.openqa.selenium.WebDriver;

public class CoursePage extends Page{

    public CourseTabPage courseTabPage;
    public CourseListPage courseListPage;

    public CoursePage(WebDriver driver) {
        super(driver);
        courseTabPage = new CourseTabPage(driver);
        courseListPage = new CourseListPage(driver);
    }

    public void selectCourseType(String typeName){
        courseTabPage.tabClick(typeName);
    }

    public int getLessonCount(){
        return courseListPage.getListCount();
    }
    public void openUrl() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webTools.openUrl("http://www.jd100.com/studycenter/#/courses/");

    }

}
