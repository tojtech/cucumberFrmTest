package com.amriya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.safari.driver","//usr//bin//safaridriver");
        WebDriver driver = new SafariDriver();
        driver.get("https://www.kinogo.by/");
        System.out.println(driver.getTitle());
    }
}
