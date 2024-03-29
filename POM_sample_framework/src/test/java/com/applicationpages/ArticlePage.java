package com.applicationpages;

import com.applicationobjects.ArticlePageOR;
import com.applicationobjects.HomePageOR;
import com.genericmethods.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class ArticlePage extends GenericMethods {
    private static ArticlePageOR articlePageOR;
    private static HomePageOR homePageOR;
    private static ArticlePage articlePage;
    public static ArticlePage getInstance() {
        if (articlePage == null) {
            articlePage = new ArticlePage();
            articlePageOR = PageFactory.initElements(driver, ArticlePageOR.class);
            homePageOR = PageFactory.initElements(driver, HomePageOR.class);
        }
        return articlePage;
    }

}









