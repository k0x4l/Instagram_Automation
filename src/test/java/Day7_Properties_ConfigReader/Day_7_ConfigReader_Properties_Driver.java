package Day7_Properties_ConfigReader;

import TestBase.Before_After_Class;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Day_7_ConfigReader_Properties_Driver extends Before_After_Class {

    @Test(priority = 3)
    public void See_All_Suggestions()throws InterruptedException{
        Thread.sleep(4000);
        WebElement SeeAllButton = driver.findElement(By.xpath("//div[@class='_7UhW9  PIoXz        qyrsm KV-D4         uL8Hv         ']"));
        SeeAllButton.click();
        Thread.sleep(4000);
    }

    @Test (priority = 4)
    public void FollowAccounts() throws InterruptedException{

        for ( int i=1 ; i<k ; i++ ) {
            driver.findElement(By.xpath("//button[@class='sqdOP  L3NKy   y3zKF     ']")).click();
            Thread.sleep(500);
            WebElement accountToFollow = driver.findElement(By.xpath("(//div[@class='_7UhW9   xLCgt       qyrsm KV-D4             fDxYl      rWtOq']/div)["+i+"]"));
            accountName = accountToFollow.getText();
            //WebElement accountNameToText = driver.findElement(By.xpath("(//div[@class='_7UhW9   xLCgt      MMzan   _0PwGv        uL8Hv         '])["+i+"]"));
            //accountName = accountNameToText.getText();
            System.out.println(listOfAccounts.get(i-1));
            listOfAccounts.add(accountName);
        }
        Thread.sleep(3000);
    }

    //@Test (priority = 5)
    public void directMessage_Method1() throws InterruptedException{
        WebElement directMessageIcon = driver.findElement(By.xpath("//a[@class='xWeGp']"));       //Direct Message icon
        directMessageIcon.click();               //Click Direct Message icon
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='sqdOP  L3NKy   y3zKF     ']")).click(); // Click "Send Message" button
        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for ( int i=1; i<k ; i++ ) {

            WebElement SearchAccount = driver.findElement(By.xpath("//input[@name='queryBox']")); //Search Account
            SearchAccount.sendKeys(listOfAccounts.get(i - 1) + Keys.ENTER);
            Thread.sleep(1500);
            driver.findElement(By.xpath("//button[@class='dCJp8 ']")).click(); // Select the account
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[@class='sqdOP yWX7d    y3zKF   cB_4K  ']")).click(); // Click "Next" Button
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@class='X3a-9']/div/textarea")).sendKeys(message + Keys.ENTER); // Enter the Message and send
            driver.navigate().back(); // Come Back
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        driver.navigate().back();
    }

    @Test (priority = 6)
    public void directMessage_Method2() throws InterruptedException {
        for ( int i = 1; i < k; i++ ) {
            WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search']"));
            searchBar.sendKeys(listOfAccounts.get(i-1) + Keys.ENTER );
            WebElement accountToSelect = driver.findElement(By.xpath("//div[@class='fuqBx']/a")); // Select the account
            Thread.sleep(500);
            accountToSelect.click();
            Thread.sleep(500);
            WebElement messageIcon = driver.findElement(By.xpath("//button[.='Message']"));
            messageIcon.click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@class='X3a-9']/div/textarea")).sendKeys(message + Keys.ENTER); // Enter the Message and send
            Thread.sleep(500);

        }
    }

}
