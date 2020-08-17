package com.amriya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http:login.salesforce.com");
        Thread.sleep(2000);
        /** This step below types an
         *
         */
        driver.findElement(By.cssSelector("input[id='username'")).sendKeys("iwefuhwifhewufiw");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wkjfbwefbwe;f");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='Login']")).click();
        driver.quit();

    }
}
