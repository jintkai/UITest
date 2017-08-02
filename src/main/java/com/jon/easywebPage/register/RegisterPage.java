package com.jon.easywebPage.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jon.common.Tools;
import com.jon.easywebPage.Page;
import com.jon.easywebPage.common.GradeDomain;
import com.jon.easywebPage.school.SchoolDomain;
import com.jon.easywebPage.school.SchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class RegisterPage extends Page{

    private SchoolPage schoolPage;

    public RegisterPage(WebDriver driver){
        super(driver);
        schoolPage = new SchoolPage(driver);
//        webTools.openUrl("http://www.jd100.com/user/register/?specialcode=304");
        webTools.openUrl("http://www.jd100.com/user/register");

    }
    public RegisterPage(){

    }

    @FindBy(id = "iuserName")
    private WebElement iuserName;

    @FindBy(id = "iuserPwd")
    private WebElement iuserPwd;

    @FindBy(id = "iuseragainPwd")
    private WebElement iuseragainPwd;

    @FindBy(id = "iqq")
    private WebElement iqq;

    @FindBy(id = "ifigureStudent")
    private WebElement ifigureStudent;
    @FindBy(id = "ifigureTeacher")
    private WebElement ifigureTeacher;
    @FindBy(id = "ifigurePatriarch")
    private WebElement ifigurePatriarch;

    @FindBy(className = "j_gradeBtn")
    private WebElement j_gradeBtn;
    @FindBy(className = "reg-gradeList-items")
    private WebElement regGradeListItems;

    @FindBy(id = "j_selectTrigger")
    private WebElement j_selectTrigger;

    @FindBy(id = "irealname")
    private WebElement irealname;

    @FindBy(id = "id_mobilePhone")
    private WebElement id_mobilePhone;

    @FindBy(id = "registerAction")
    private WebElement registerAction;

    @FindBy(className = "bg_joinGroup")
    private WebElement bg_joinGroup;



    public void register(RegisterDomain domain)
    {
        webTools.sendKeys(iuserName,domain.getUserName(),true);
        webTools.sendKeys(iuserPwd,domain.getPasswd(),true);
        webTools.sendKeys(iuseragainPwd,domain.getPasswd(),true);
        webTools.sendKeys(iqq,domain.getQqORmail(),true);
        if (domain.getIdentity().equals("学生")) {
            webTools.click(ifigureStudent);

        } else if (domain.getIdentity().equals("家长")) {
            webTools.click(ifigurePatriarch);

        } else {
            webTools.click(ifigureStudent);//暂时不支持老师

        }

        j_gradeBtn.click();
        WebElement element = webTools.findElement(regGradeListItems, By.xpath("//div[.='"+domain.getGradeDomain().getGrade()+"']"));
        webTools.click(element);
        element = webTools.findElement(regGradeListItems, By.xpath("//li[.='"+domain.getGradeDomain().getGradeSub()+"']"));
        webTools.click(element);
        webTools.click(j_selectTrigger);
        schoolPage.selectSchool(domain.getSchoolDomain());
        irealname.sendKeys(domain.getRealName());
        id_mobilePhone.sendKeys(domain.getMobile());
        webTools.click(registerAction);
        System.out.println(webTools.getHtml());
    }

    @Test
    public void testRegister(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/jon/Downloads/chromedriver");
        driver = new ChromeDriver();
        RegisterPage registerPage = new RegisterPage(driver);
        String userName = "tester"+ Tools.getRandomNumber();
        String mobile = "179"+Tools.getRandomNumber();
        RegisterDomain domain = new RegisterDomain(userName,"123456","710307018",
                "学生","测试人员",mobile,
                new SchoolDomain("西藏","山南","乃东县","山南地区高级中学"),
                new GradeDomain("高中","2016年高中入学"));

        registerPage.register(domain);

    }


}
