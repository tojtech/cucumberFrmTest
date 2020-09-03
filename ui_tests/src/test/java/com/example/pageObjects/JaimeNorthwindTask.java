//package com.example.pageObjects;
//
//import com.example.TestsConfig;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Given;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import static com.example.CucumberHooks.getDriver;
//import com.example.BasePage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import java.util.List;
//import static com.example.helpers.ElementsInteraction.getWait;
//
//
///**
// * This class contains global (common) steps that do not belong to any specific page
// * As well as all the entry points into the system (open a url)
// */
//public class JaimeNorthwindTask {
//
//    @Given("I open index page")
//    public BigprofIndexPage iOpenIndexPage() throws InterruptedException {
////        Base URL is read from config.properties file located in resources folder. Key is base.url
//        String baseUrl = TestsConfig.getConfig().getBaseUrl();
//        getDriver().get(baseUrl);
//        Thread.sleep(500);
//
//        WebElement element = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
//        Thread.sleep(500);
//        element.click();
//        return new BigprofIndexPage();
//    }
//
//    @When("sleep")
//    public void sleep() throws InterruptedException {
//        Thread.sleep(4000);
//    }
//
//    /**
//     * Name of the page represents the web page name.
//     * It extends the BasePage abstract class that implements common logic for page loading.
//     * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
//     */
//    public class BigprofIndexPage extends BasePage {
//        /**
//         * This method is executed whenever new object of class is created.
//         * It's done by calling the method in constructor of BasePage class
//         */
//        public void isPageOpened() {
////        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
//            getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
//        }
//
//        @And("^user clicks Sign In button on the top right corner$")
//        public SignupPage clickSigninButton() {
//            getSigninButton().click();
//            return new SignupPage();
//        }
//
//        // GETTERS BELOW
//        public WebElement getSigninButton() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/a"));
//        }
//
//    }
//
//    public class SignupPage extends BasePage {
//        /**
//         * This method is executed whenever new object of class is created.
//         * It's done by calling the method in constructor of BasePage class
//         */
//        public void isPageOpened() {
////        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
//            getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
//        }
//
//        @And("^user clicks at Sign Up button on the top right corner$")
//        public void clickSignupButton() {
//            getSignup().click();
//        }
//
//        @And("^user fills out Sign Up form$")
//        public void fillSignupForm() throws InterruptedException {
//            String username = "jaime2"; //NOTE before each execution remember to change username
//            getUsernameBox().sendKeys(username);
//            Thread.sleep(2000);
//
//            String password = "Showroom654";
//            getPassword().sendKeys(password);
//            getConfirmPassword().sendKeys(password);
//            Thread.sleep(2000);
//
//            String emailAddress = "jalencastro@hotmail.com";
//            getEmailAddress().sendKeys(emailAddress);
//            Thread.sleep(2000);
//
//            String fullName = "Jaime Tojtech";
//            getFullName().sendKeys(fullName);
//            Thread.sleep(2000);
//
//            String address = "123 Fairytale Lane";
//            getAddress().sendKeys(address);
//            Thread.sleep(2000);
//
//            String city = "Lefrak";
//            getCity().sendKeys(city);
//            Thread.sleep(2000);
//
//            String state = "New York";
//            getState().sendKeys(state);
//            Thread.sleep(2000);
//        }
//
//        @And("^user clicks Sign Up button on bottom of page$")
//        public void submitSignupButton() throws InterruptedException {
//            getSignUpButton().click();
//            Thread.sleep(10000);
//        }
//
//
//// ********************** GETTERS *****************
//
//        public WebElement getSignup() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/a"));
//        }
//
//        public WebElement getUsernameBox() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[1]/input"));
//        }
//
//        public WebElement getPassword() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/div[1]/div/input"));
//        }
//
//        public WebElement getConfirmPassword() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/div[2]/div/input"));
//        }
//
//        public WebElement getEmailAddress() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[3]/input"));
//        }
//
//        public WebElement getFullName() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[5]/div[2]/input"));
//        }
//
//        public WebElement getAddress() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[6]/div[2]/input"));
//        }
//
//        public WebElement getCity() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[7]/div[2]/input"));
//        }
//
//        public WebElement getState() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[8]/div[2]/input"));
//        }
//
//        public WebElement getSignUpButton() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[9]/div/button"));
//        }
//    }
//
//    public class SignedInPage extends BasePage {
//        /**
//         * This method is executed whenever new object of class is created.
//         * It's done by calling the method in constructor of BasePage class
//         */
//        public void isPageOpened() {
////        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
//            getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
//        }
//
//        @And("^user verifies he is logged in$")
//        public void verifyLogin() throws InterruptedException {
//            String username = "jaime2"; //NOTE before each execution remember to change username
//            getUsernameBox().sendKeys(username);
//            Thread.sleep(2000);
//
//            String password = "Showroom654";
//            getPassword().sendKeys(password);
//            Thread.sleep(2000);
//
//            getSignInButton().click();
//
//            Assert.assertEquals(getVerifiedUsername().getText(), "jaime2");
//        }
//
//        @And("^verify description of Orders contains \"([^\"]*)\"$")
//        public void verifyOrdersDescription(String ordersText) throws InterruptedException {
//            Assert.assertTrue(getOrderText().getText().contains(ordersText));
//            Thread.sleep(2000);
//        }
//
//        @And("^user clicks on Orders button$")
//        public void clickOrdersButton() throws InterruptedException {
//            getClickOrdersButton().click();
//            Thread.sleep(2000);
//        }
//
//        @And("^user verifies Orders page is opened$")
//        public void verifyOrdersPageOpened() {
//            Assert.assertEquals(getDriver().getTitle(), "Northwind | Orders");
//        }
//
//        @And("^user clicks Sales dropdown at the header$")
//        public void clickSalesDropdown() throws InterruptedException {
//            getClickSalesDropdown().click();
//            Thread.sleep(2000);
//        }
//
//        @And("^user then clicks Customers from that dropdown$")
//        public void clickCustomersFromDropdown() throws InterruptedException {
//            getClickCustomersFromDropdown().click();
//            Thread.sleep(2000);
//        }
//
//        @And("^user verifies Customers page is opened$")
//        public void verifyCustomersPageOpened() {
//            Assert.assertEquals(getDriver().getTitle(), "Northwind | Customers");
//        }
//
//        @And("^user clicks on Customer ID Anton$")
//        public void clickCustomerAnton() throws InterruptedException {
//            getClickCustomerAnton().click();
//            Thread.sleep(2000);
//        }
//
//        @And("^user verifies Anton customer page is opened$")
//        public void verifyAntonOpened() {
//            Assert.assertEquals(getVerifiedAnton().getText(), "ANTON");
//        }
//
//
//// ********************** GETTERS *****************
//
//        public WebElement getUsernameBox() {
//            return getDriver().findElement(By.xpath("//input[@id='username']"));
//        }
//
//        public WebElement getPassword() {
//            return getDriver().findElement(By.xpath("//input[@id='password']"));
//        }
//
//        public WebElement getClickCustomerAnton() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table/tbody/tr[3]/td[2]/a"));
//        }
//
//        public WebElement getClickCustomersFromDropdown() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[1]/li[1]/ul/li[1]/a"));
//        }
//
//        public WebElement getClickSalesDropdown() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[1]/li[1]/a"));
//        }
//
//        public WebElement getOrderText() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div[2]"));
//        }
//
//        public WebElement getVerifiedUsername() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[2]/p/strong/a"));
//        }
//
//        public WebElement getSignInButton() {
//            return getDriver().findElement(By.xpath("//button[@id='submit']"));
//        }
//
//        public WebElement getClickOrdersButton() {
//            return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div[1]/a[1]/strong"));
//        }
//
//        public WebElement getVerifiedAnton() {
//
//            return getDriver().findElement(By.xpath("//div[@id='CustomerID']"));
//        }
//    }
//}