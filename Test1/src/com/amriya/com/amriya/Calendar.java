package com.amriya;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxPractise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.cssSelector("#checkbox-example")).size());
        driver.findElement(By.id("checkBoxOption1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkBoxOption1")).isSelected();
        Thread.sleep(2000);
        driver.findElement(By.id("checkBoxOption1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkBoxOption2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("checkBoxOption2")).click();
        Thread.sleep(1000);
        //System.out.println(driver.findElements(By.cssSelector("div[id='checkbox-example']")).size());
        driver.quit();


    }
}
