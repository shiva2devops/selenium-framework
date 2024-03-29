package com.applicationobjects;

import com.applicationpages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePageOR {

    @FindBy(xpath = "//*[@id=\"news-wrapper\"]/div[2]/header/div[1]/div/div/div/a/img")
    public WebElement lnk_home;

   
}
