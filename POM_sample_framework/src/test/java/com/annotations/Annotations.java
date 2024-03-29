package com.annotations;

import com.genericmethods.GenericMethods;
import com.getconfidetails.ReadConfigDetails;
import com.readtestdata.ReadJsonData;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Annotations extends ReadJsonData {
    @BeforeSuite
    public void beforeSuite()
    {
        ReadConfigDetails readConfigDetails = new ReadConfigDetails();
        readConfigDetails.loadProperties();
        ReadJsonData readJsonData = new ReadJsonData();
        readJsonData.loadJsonFile();

    }
    @BeforeMethod
    public void beforeMethod(Method m){

        testCase=m.getName().toString();
    }

//    @AfterSuite
//    public void afterSuite()
//    {
//      //GenericMethods.driver.close();
//      GenericMethods.driver.quit();
//    }

//    @AfterMethod
//    public void afterMethod()
//    {
//        GenericMethods.driver.close();
//        //GenericMethods.driver.quit();
//    }

    @AfterMethod
    public void afterTest()
    {
        //GenericMethods.driver.close();
       GenericMethods.driver.quit();
    }

}
