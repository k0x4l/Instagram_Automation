package TestBase;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Before_After_Class {

    protected WebDriver driver;

    protected String username = ConfigurationReader.getProprty("username_3");
    protected String password = ConfigurationReader.getProprty("password");

    public String accountName;
    public String message = ConfigurationReader.getProprty("message");
    public ArrayList<String> listOfAccounts = new ArrayList<String>();
    public String acoountNumber = ConfigurationReader.getProprty("k");
    public int k = Integer.parseInt(acoountNumber);
    // index starts with 1. If we want to x account to follow and to send direct message, we have to use x+1


    @BeforeClass
    public void setUp() throws InterruptedException {

        driver = Driver.getDriver();
        driver.get("https://www.instagram.com/accounts/login/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        validUserCredentials();
        notNowsClick();

    }

    void validUserCredentials() throws InterruptedException{
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password+ Keys.ENTER);
        Thread.sleep(3000);
    }

    void notNowsClick(){
        driver.findElement(By.cssSelector("button[class='sqdOP yWX7d    y3zKF     ']")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[class='aOOlW   HoLwm ']")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
    }

    //@Ignore --> It does not work
    //@AfterClass
    public void tearDown() {
        driver.quit();
    }
}
