package com.applicationpages;

import com.applicationobjects.HomePageOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class HomePage extends GenericMethods {
    private static HomePageOR homePageOR;
    private static HomePage homePage;
    public static HomePage getInstance() {
        if (homePage == null) {
            homePage = new HomePage();
            homePageOR = PageFactory.initElements(driver, HomePageOR.class);
        }
        return homePage;
    }
}






















