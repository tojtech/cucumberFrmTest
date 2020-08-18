
package com.example.pageObjects;
//import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Naseem {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://spicejet.com");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5");
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("Is Disabled");
            Assert.assertTrue(true);
        }
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        driver.findElement(By.id("Div1")).getAttribute("style").contains("1");
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("Is Enabled");
            Assert.assertTrue(true);
        }
        Thread.sleep(1000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        int i=0;
        while(i<9)
        {
            select.selectByIndex(i);
            i++;
            Thread.sleep(2000);
        }
        //driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']/option[4]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);



        driver.quit();
    }

}

