package Day2_click_NotNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day_02_Click_NotNow_v1 {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\__{{ KoxaL }}__\\IdeaProjects\\seleniumprojectb18\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/accounts/login/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("cilekcicocuk");
        driver.findElement(By.name("password")).sendKeys("Instagram.2020"+ Keys.ENTER);

        //driver.manage().timeouts().pageLoadTimeout(4,TimeUnit.SECONDS);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("button[class='sqdOP yWX7d    y3zKF     ']")).click();

        //Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("button[class='aOOlW   HoLwm ']")).click();
/*
        for(int i=0; i<5 ; i++) {
            for ( int z=0 ; z<5 ; z++ ) {
                Thread.sleep(4000);
                driver.findElement(By.cssSelector("button[class='PoNcp sqdOP yWX7d    y3zKF     ']")).click();
                Thread.sleep(1000);
            }
            driver.navigate().refresh();
        }

 */

        driver.close();
    }
}
