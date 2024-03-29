package com.genericmethods;

import com.annotations.Annotations;
import com.applicationobjects.HomePageOR;
import com.getconfidetails.ReadConfigDetails;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit;

public class GenericMethods extends Annotations {

    public static WebDriver driver;



    //Launching Browser
    @Step("Launching the browser")
    public boolean launchBrowser() {
        boolean status = true;
        ReadConfigDetails property = new ReadConfigDetails();

        try {
            switch (property.getProperty("BROWSER").toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.get(property.getProperty(property.getProperty("EXECUTE_ENVIRONMENT") + ("_APP_URL")));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            Thread.sleep(10000);
            try {
//                WebDriverWait wait= new WebDriverWait(driver ,Duration.ofSeconds(25));
//                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='close w-inline-block']"))));
                WebElement ele=driver.findElement(By.xpath("//*[@class='close w-inline-block']"));
                Actions act=new Actions(driver);
                act.moveToElement(ele).click().build().perform();
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            driver.findElement(By.xpath("//*[@class='uc-btn-agree-cookie']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        } catch (Exception e) {
            status = false;
            System.out.println(e.getMessage());
        }
        return status;
    }





    public boolean clickElement(String pageName, String elementName, WebElement element){
        boolean status = true;
        try
        {
            Actions acc= new Actions(driver);
            acc.moveToElement(element).click(element).build().perform();
        }
        catch (Exception e)
        {
            status= false;
        }
        return status;
    }
    public boolean sendData(String pageName, String elementName, WebElement element, String data){
        boolean status = true;
        try
        {
            Actions acc= new Actions(driver);
            acc.moveToElement(element).click(element).build().perform();
            element.clear();
            element.sendKeys(data);
        }
        catch (Exception e)
        {
            status= false;
        }
        return status;
    }

    public boolean selectDropdownByText(String pageName, String elementName, WebElement element, String data){
        boolean status = true;
        try
        {
            Select select= new Select(element);
            select.selectByVisibleText(data);
        }
        catch (Exception e)
        {
            status= false;
        }
        return status;
    }
    public boolean selectDropdownByValue(String pageName, String elementName, WebElement element, String data){
        boolean status = true;
        try
        {
            Select select= new Select(element);
            select.selectByValue(data);
        }
        catch (Exception e)
        {
            status= false;
        }
        return status;
    }
    public boolean selectDropdownByIndex(String pageName, String elementName, WebElement element, int data){
        boolean status = true;
        try
        {
            Select select= new Select(element);
            select.selectByIndex(data);
        }
        catch (Exception e)
        {
            status= false;
        }
        return status;
    }
    public boolean waitForElementToBeClickable(WebElement element, int sec)
    {
        Boolean status = true;
        try{
            WebDriverWait wait= new WebDriverWait(driver ,Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status;
    }
    public static boolean PageScrollbyJS(WebElement element)
    {
        Boolean status01 = true;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status01;
    }
    public static boolean ElementClickbyJS(WebElement element)
    {
        Boolean status01 = true;
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status01;
    }

    public boolean waitForElementToDisplay(WebElement element, int sec)
    {
        Boolean status = true;
        try{
            WebDriverWait wait= new WebDriverWait(driver ,Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status;
    }
    public boolean applyFluentwaitForElementDispaly(WebElement element, int sec)
    {
        Boolean status = true;
        try{
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return status;
    }
    public boolean MoveToElement(String pageName, String elementName, WebElement element){
        boolean status = true;
        try
        {
            Actions acc= new Actions(driver);
            acc.moveToElement(element).build().perform();
        }
        catch (Exception e)
        {
            status= false;
        }
        return status;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        TakesScreenshot sht = (TakesScreenshot) driver;
        return sht.getScreenshotAs(OutputType.BYTES);
    }
}
