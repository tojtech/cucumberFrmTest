package com.facebook.pageObjects;

import com.facebook.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.facebook.CucumberHooks.getDriver;
import static com.facebook.helpers.ElementsInteraction.getWait;
import static java.lang.Thread.sleep;


public class Project1 {
   @And("^Go through sign up process$")
    public void signUp() throws InterruptedException {
       getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/a")).click(); //click sign in button

       Thread.sleep(2000);

       getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/a")).click();//click sign up button

       Thread.sleep(2000);

       getDriver().findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Msavich7");//enter UserName;

       Thread.sleep(2000);

       getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345.Aa"); // enter password

       getDriver().findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("12345.Aa");// enter confirm password

       getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("savich.maria1@gmail.com"); // enter email address

       getDriver().findElement(By.xpath("//*[@id=\"custom1\"]")).sendKeys("Maria Savich");// enter Full name

       getDriver().findElement(By.xpath("//*[@id=\"custom2\"]")).sendKeys("123 Address"); // Enter Address

       getDriver().findElement(By.xpath("//*[@id=\"custom3\"]")).sendKeys("City"); // Enter City

       getDriver().findElement(By.xpath("//*[@id=\"custom4\"]")).sendKeys("New York"); // Enter state

       getDriver().findElement(By.xpath("//*[@id=\"submit\"]")).click(); // Click Sign up button

       Thread.sleep(10000);


   }



   @And("^Login to the site$")
   public void logIn() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Msavich7");

        getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345.Aa");

        getDriver().findElement(By.xpath("//*[@id=\"submit\"]")).click();

        Thread.sleep(2000);
   }

   @And("^Click AppGini Homepage$")
    public void appGini(){
       getDriver().findElement(By.xpath("//*[@id=\"group-11ff9f68afb6b8b5b8eda218d7c83a65\"]/div[2]/div[1]/div/div/a")).click();


   }
    @And("^Verify Gini project is opened$")
    public AppGiniPage giniPageVerify(){
        Assert.assertEquals(getDriver().getTitle(), "AppGini, web database applications builder without coding");
        return new AppGiniPage();
    }
    @And("^Go back to Northwind Homepage$")
    public void backToNorthwind(){
        getDriver().navigate().back();

    }
    @And("^Click “Change theme” at the bottom$")
    public void changeTheme() throws InterruptedException {
       getDriver().findElement(By.xpath("//*[@id=\"demo-options\"]")).click();
       Thread.sleep(2000);
    }
    @And("^Verify “Change the theme of this demo“ modal is appeared$")
    public void changeTheThemeVerified() throws InterruptedException {
       Assert.assertEquals(getModalName().getText(),"Change the theme of this demo");
       Thread.sleep(2000);
//               Assert.assertTrue(changeTheThemeModal().getText().contains("Cosmo"));
    }
    @And("^Select “Cosmo“ theme$")
    public void selectCosmoTheme() throws InterruptedException {
//       getDriver().findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div/select")).click();
//
//       Thread.sleep(2000);

       WebElement drop = getDriver().findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div/select"));

        Actions a = new Actions(getDriver());

        a.moveToElement(drop);

        a.perform();

        Select cosmoOption = new Select(drop);

        cosmoOption.selectByValue("cosmo.css");

        Thread.sleep(2000);

//
//    Select s =new Select(getDriver().findElement(By.xpath("/html/body/div[2]/div/select/option[3]")));
//    s.selectByValue("cosmo.css");
    }
    @And("^Click Apply button$")
    public void clickApply(){
       getDriver().findElement(By.xpath("/html/body/div[8]/div/div/div[3]/button")).click();
    }
    @And("^Click “More info“ button$")
    public void clickMoreInfo() throws InterruptedException {
       getDriver().findElement(By.xpath("/html/body/div[4]/div/button[3]")).click();
       Thread.sleep(2000);
    }
    @And("^Verify “About this demo“ modal is opened$")
    public void verifyAboutThisDemo() throws InterruptedException {
       Assert.assertEquals(getAboutThisDemo().getText(), "About this demo");
        Thread.sleep(2000);
    }
    public WebElement getModalName(){
       return getDriver().findElement(By.xpath("/html/body/div[8]/div/div/div[1]/h4"));
    }

    public WebElement getAboutThisDemo(){
       return getDriver().findElement(By.xpath("/html/body/div[9]/div/div/div[1]/h4"));
    }

}
