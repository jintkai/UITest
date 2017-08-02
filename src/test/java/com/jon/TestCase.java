package com.jon;

import com.jon.common.web.EventListener;
import com.jon.common.web.WebTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCase {

    public WebDriver driver;
    public EventFiringWebDriver eventDriver;
    public WebTools webTools;
    String node;

    public WebDriver 	createDriver(String BrowserType,String nodeURL) {
        if(nodeURL.equals("")){
            System.setProperty("webdriver.chrome.driver","/Users/jon/Downloads/chromedriver");
            return driver = new ChromeDriver();
        }
        if(BrowserType.equals("ie"))
        {
            //DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            //ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            DesiredCapabilities test=DesiredCapabilities.internetExplorer();
            try {
                driver = new RemoteWebDriver(new URL(nodeURL),test);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
        if(BrowserType.equals("firefox"))
        {
            DesiredCapabilities test = DesiredCapabilities.firefox();
            try {
                driver = new RemoteWebDriver(new URL(nodeURL),test);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
        if(BrowserType.equals("safari")){
            try {
                driver = new RemoteWebDriver(new URL(nodeURL),DesiredCapabilities.safari());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        if(BrowserType.equals("chrome"))
        {
            try {
                driver = new RemoteWebDriver(new URL(nodeURL), DesiredCapabilities.chrome());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        if(BrowserType.toLowerCase().equals("htmlUnit".toLowerCase()))
        {
            driver = new FirefoxDriver();

        }
        return driver;
    }


    public EventFiringWebDriver getEventDriver(){return  eventDriver;}

//    @Parameters({"Base_URL"})
//    @BeforeClass(alwaysRun=true)
    public void beforeClass(String base_url)
    {
        System.out.println("TestCase before class");

        driver=createDriver("chrome",node);
        eventDriver=new EventFiringWebDriver(driver);
        eventDriver.register(new EventListener());
        webTools=new WebTools(eventDriver);
        eventDriver.get("http://www.jd100.com");
        eventDriver.manage().window().maximize();
    }

    public TestCase(String node)
    {
        this.node = node;
        beforeClass(node);
    }



    @AfterClass(alwaysRun=true)
    public  void afterClass()
    {
        eventDriver.close();
        eventDriver.quit();

    }


}
