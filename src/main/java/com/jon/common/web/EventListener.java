package com.jon.common.web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventListener implements WebDriverEventListener {

    //Logger mylog=Logger.getLogger(this.getClass());

    public StringBuffer getElementsAttrs(WebElement webElement){
        StringBuffer attrs=new StringBuffer();

        attrs.append(">>>>>>TAG:").append(webElement.getTagName()).append(".TEXT:").append(webElement.getText())
                .append(".ID:").append(webElement.getAttribute("id")).append(".NAME:")
                .append(webElement.getAttribute("name")).append("...");

        return attrs;
    }
    public EventListener(){
        //PropertyConfigurator.configure( "./config/log4j.properties" );
        //Logger logger  =  Logger.getLogger(this.getClass() );
    }


    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    public void afterNavigateTo(String url, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }

    public void afterNavigateForward(WebDriver driver) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeFindBy(final By by, final WebElement webElement, WebDriver webDriver) {
        WebDriverWait wait=new WebDriverWait(webDriver,10,100);
        if(webElement!=null)
        {

            try {
                WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver webDriver) {
                        return webElement.findElement(by);
                    }
                });
            }
            catch(TimeoutException e)
            {
                //mylog.error("定位元素超时."+by.toString());
            }
        }
        else
        {
            try {

                Boolean b=wait.until(new ExpectedCondition<Boolean>(){

                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElements(by).size()!=0;
                    }
                });

            }
            catch(TimeoutException e)
            {
                //mylog.error("定位元素超时."+by.toString());
            }
        }

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void beforeClickOn(final WebElement webElement, WebDriver webDriver) {
        WebDriverWait wait=new WebDriverWait(webDriver,10,100);
        System.out.println("点击元素:"+getElementsAttrs(webElement));
        if(webElement!=null)
        {

            try {
                Boolean element = wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webElement.isDisplayed();
                    }
                });
            }
            catch(TimeoutException e)
            {

            }
        }

    }

    public void afterClickOn(WebElement element, WebDriver driver) {

    }


    public void beforeChangeValueOf(final WebElement webElement, WebDriver webDriver) {
        WebDriverWait wait=new WebDriverWait(webDriver,10,100);
        System.out.println("修改元素值:"+getElementsAttrs(webElement));
        if(webElement!=null)
        {

            try {
                Boolean element = wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {

                        return (webElement.isDisplayed() && webElement.isEnabled());
                    }
                });

            }
            catch(TimeoutException e)
            {

            }
        }
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    public void beforeScript(String script, WebDriver driver) {

    }

    public void afterScript(String script, WebDriver driver) {

    }


    public void onException(Throwable throwable, WebDriver webDriver) {

        ITestResult result= Reporter.getCurrentTestResult();
        String fileName= Reporter.getCurrentTestResult().getMethod().getMethodName()+ Reporter.getCurrentTestResult().getMethod().getDescription();
        fileName=fileName.replaceAll(",","");
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMddHHmmss");

        String formatDate=dateFormat.format(new Date());

        fileName=fileName+formatDate;
        String imageFormat = "png";// 图像文件的格式
        String picDir= "./pictures/";
        String str= String.valueOf((int)(Math.random()));
        File srcFile=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = null;
        try {
            image = ImageIO.read(srcFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics g = image.getGraphics();
        g.setFont(new Font("Serif",Font.BOLD,15));
        g.setColor(Color.red);
        g.drawString(throwable.getMessage(), 10, 15);


        String filename=picDir+fileName+"."+imageFormat;
        try {
            ImageIO.write(image, "png", new File(filename));
            Reporter.log("onException:TakesScreenshot Save File:"+filename+"....Finished!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
