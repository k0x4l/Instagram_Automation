package Day3_TestNG;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Day_03_TransportToTestNG {

    WebDriver driver;

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
        driver.findElement(By.name("username")).sendKeys("cilekcicocuk");
        driver.findElement(By.name("password")).sendKeys("Instagram.2020"+ Keys.ENTER);
        Thread.sleep(3000);
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test (priority = 2)
    public void notNowClick_1(){
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[class='sqdOP yWX7d    y3zKF     ']")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        //Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='aOOlW   HoLwm ']")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        //Thread.sleep(2000);

    }
    @Test (priority = 3)
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
    @AfterClass
    public void tearDown() throws InterruptedException{
        Thread.sleep(4000);
        driver.close();
    }

}
