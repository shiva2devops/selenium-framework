package com.testcases;

import com.applicationpages.ArticlePage;
import com.applicationpages.HomePage;
import com.genericmethods.GenericMethods;
import org.testng.annotations.Test;

public class test extends GenericMethods
{
    @Test

    public void test()
    {
        launchBrowser();
        ArticlePage articlePage = ArticlePage.getInstance();
        HomePage homePage= HomePage.getInstance();
        System.out.println("hello");
    }
}
