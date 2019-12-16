package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BasePage {

    //no ned to explicitly write constructors, because it will use its parents constructor.

    public DashBoardPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
