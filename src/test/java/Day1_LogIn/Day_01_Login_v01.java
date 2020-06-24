package Day1_LogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day_01_Login_v01 {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\__{{ KoxaL }}__\\IdeaProjects\\seleniumprojectb18\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/accounts/login/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("cilekcicocuk");
        driver.findElement(By.name("password")).sendKeys("Instagram.2020"+ Keys.ENTER);

    }
}
