package com.amriya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naseem {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http:rediff.com");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#password")).sendKeys("shbdqlhjdbq");
        driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();

        driver.close();
    }
}
