package Day5_More_Stable_Same_As_Day4;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Day_5_More_Stable {


    WebDriver driver;
    String username = "cilekcicocuk" ;
    //String username = "lady_cilekci" ;
    String password = "Instagram.2020" ;
    String accountName;
    String message = "Hi!! How re u ??\nFollow to Follow ; ))";
    WebElement messageTextArea;
    ArrayList<String> listOfAccounts = new ArrayList<String>();
    int k = 11; //index starts with 1. If we want to x account to follow and to send direct message, we have to use x+1

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.instagram.com/accounts/login/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test (priority = 1)
    public void validUserCredentials()throws InterruptedException{
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password+ Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void notNowClick_1(){
        driver.findElement(By.cssSelector("button[class='sqdOP yWX7d    y3zKF     ']")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[class='aOOlW   HoLwm ']")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
    }
    //@Test (priority = 3)
    public void Follow_5_Account(){
        for(int i=0; i<2 ; i++) {
            for ( int z=0 ; z<5 ; z++ ) {
                driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
                driver.findElement(By.cssSelector("button[class='PoNcp sqdOP yWX7d    y3zKF     ']")).click();
                driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
            }
            driver.navigate().refresh();
        }
    }
    @Test (priority = 3)
    public void goToExplore(){
        driver.findElement(By.cssSelector("svg[aria-label='Find People']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test (priority = 4)
    public void seeAll() throws InterruptedException{
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[class='HUW1v hUQXy']")).click(); //Click "seeAll" button
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        for ( int i=1 ; i<k ; i++ ) {
            driver.findElement(By.cssSelector("button[class='sqdOP  L3NKy   y3zKF     ']")).click();
            Thread.sleep(500);
            WebElement accountToFollow = driver.findElement(By.xpath("(//div[@class='_7UhW9   xLCgt       qyrsm KV-D4             fDxYl      rWtOq']/div)["+i+"]"));
            accountName = accountToFollow.getText();
            listOfAccounts.add(accountName);
            System.out.println(listOfAccounts.get(i-1));
        }
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void directMessage() throws InterruptedException{
        driver.findElement(By.cssSelector("svg[aria-label='Direct']")).click(); //Click Direct Message icon
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[class='sqdOP  L3NKy   y3zKF     ']")).click(); // Click "Send Message" button
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for ( int i=1; i<k ; i++ ) {
            WebElement SearchAccount = driver.findElement(By.cssSelector("input[name='queryBox']")); //Search Account
            SearchAccount.sendKeys(listOfAccounts.get(i-1) + Keys.ENTER);
            Thread.sleep(1500);
            driver.findElement(By.cssSelector("button[class='dCJp8 ']")).click(); // Select the account
            Thread.sleep(500);
            driver.findElement(By.cssSelector("button[class='sqdOP yWX7d    y3zKF   cB_4K  ']")).click(); // Click "Next" Button
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            Thread.sleep(500);
            driver.findElement(By.cssSelector("div[class='X3a-9']>div>textarea")).sendKeys(message + Keys.ENTER); // Enter the Message and send
            driver.navigate().back(); // Come Back
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        driver.navigate().back();
    }

    //@AfterClass
    public void tearDown() throws InterruptedException{
        Thread.sleep(4000);
        driver.close();
    }
}
