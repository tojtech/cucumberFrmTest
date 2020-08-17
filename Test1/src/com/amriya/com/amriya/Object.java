package com.amriya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Object {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("window-size=1400,1400");
        //WebDriver driver2 = new ChromeDriver(options);
        WebDriver driver = new ChromeDriver();
        driver.get("https:login.salesforce.com");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("sjnfwjfnw");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("jfnwufwiuf");
        driver.findElement(By.xpath("//*[@id='Login']")).click();

        System.out.println(driver.findElement(By.cssSelector("#error")).getText());





        //driver.findElement(By.linkText("Forgot account?")).click();

    }
}
