package com.amriya;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //driver.get("http:///yahoo.com");
        //driver.get("http://kinogo.by");
        //driver.navigate().back();
        //driver.navigate().forward();
        //driver.close(); it closes current browser
        //driver.quit(); it closes all the browsers opened by selenium scripts
        //driver.navigate().refresh();
        //System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//input[@value=Log In]"));
        driver.findElement(By.xpath("//input[@type=email]")).sendKeys("nasim.n@list.ru");

        //System.out.println(driver.getPageSource());


    }
}
