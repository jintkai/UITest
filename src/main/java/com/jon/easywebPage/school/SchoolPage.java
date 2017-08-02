package com.jon.easywebPage.school;

import com.jon.easywebPage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SchoolPage extends Page{

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

    public SchoolPage(WebDriver driver){
        super(driver);

    }

    public void selectSchool(String proviceName,String city,String district,String schoolName){
        selectProvice(proviceName);
        selectCity(city);
        selectSubdistrict(district);
        selectSchool(schoolName);
    }

    public void selectSchool(SchoolDomain domain){
        selectProvice(domain.getProvice());
        selectCity(domain.getCity());
        selectSubdistrict(domain.getSubdistrict());
        selectSchool(domain.getSchoolName());
    }

    public void selectProvice(String proviceName){
        webTools.click(webTools.findElement(By.linkText(proviceName)));

    }

    public void selectCity(String cityName){
        webTools.click(webTools.findElement(By.linkText(cityName)));

    }

    public void selectSubdistrict(String districtName){
        webTools.click(webTools.findElement(By.linkText(districtName)));
    }

    public void selectSchool(String schoolName){
        webTools.click(webTools.findElement(By.linkText(schoolName)));
    }

    public void searchSchool(String schoolName){

    }
}
