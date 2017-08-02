package com.jon.easywebPage.bindmobile;

import com.jon.common.web.WebTools;
import com.jon.easywebPage.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BindMobilePage extends Page{

    @FindBy(id = "jump_bind")
    public WebElement jumpBind;

    public void jumpBind(){
        webTools.click(jumpBind);
    }

}
