package com.jon.page.school;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchoolPage {

    @FindBy(className = "j_provice")
    WebElement provice;

    @FindBy(className = "j_city")
    WebElement city;

    @FindBy(className = "j_subdistrict")
    WebElement subDistrict;

    @FindBy(className = "j_searchName")
    WebElement searchName;

    @FindBy(className = "schoolList")
    WebElement schoolListDiv;

    public void selectProvice(String proviceName){

    }

    public void selectCity(String cityName){

    }

    public void selectSubdistrict(String districtName){

    }

    public void selectSchool(String schoolName){

    }

    public void searchSchool(String schoolName){

    }
}
