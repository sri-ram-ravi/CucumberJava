package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.Login_Page;
import stepDefinitions.Base.Hooks;

import java.time.Duration;

import static driver.Constraints.*;
import static driver.DriverFactory.getDriver;

public class Login_Steps{
    private WebDriver driver=getDriver();
    WebDriverWait wait =wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_EXPLICIT_TIMEOUT));

    Login_Page loginPage=new Login_Page(driver);

    @Given("Login page url")
    public void login_page_url() {
        driver.get(BASE_URL+"/Login-Portal/index.html");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
//        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
        loginPage.setUsername(username);
    }
    @When("I enter password  {string}")
    public void i_enter_password(String password) {
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        loginPage.setPassword(password);
    }
    @When("I click login button")
    public void i_click_login_button(){
        //driver.findElement().click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login-button']"))).click();
        loginPage.clickLogin();
    }

    @Then("alert should shown with {string} message")
    public void alert_should_shown_with_message(String expAlertMessage){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        String alertMessage=alert.getText();
        Assert.assertEquals(alertMessage,expAlertMessage);
        alert.accept();
    }
    @Then("username and password field should be empty once the alert popup closed")
    public void username_and_password_field_should_be_empty_once_the_alert_popup_closed(){
        String username=wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.username)).getText();
        String password=wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.password)).getText();
        Assert.assertEquals(username,"");
        Assert.assertEquals(password,"");
    }
}
