package com.reverb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.utility.TestUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ReverbTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://reverb.com/");
        driver.findElement(By.xpath("(//*[contains(text(),'Sign Up')])[1]")).click();
    }

    @DataProvider
    public Iterator<Object[]> getTestData(){
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void reverbTest(String firstname, String lastname, String email, String password) throws InterruptedException {

        // enter data:

        driver.findElement(By.id("user[first_name]")).clear();
        driver.findElement(By.id("user[first_name]")).sendKeys(firstname);

        driver.findElement(By.id("user[last_name]")).clear();
        driver.findElement(By.id("user[last_name]")).sendKeys(lastname);

        driver.findElement(By.id("user[email]")).clear();
        driver.findElement(By.id("user[email]")).sendKeys(email);

        driver.findElement(By.id("emailConfirmValue")).clear();
        driver.findElement(By.id("emailConfirmValue")).sendKeys(email);

        driver.findElement(By.id("user[password]")).clear();
        driver.findElement(By.id("user[password]")).sendKeys(password);

        Thread.sleep(1500);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
