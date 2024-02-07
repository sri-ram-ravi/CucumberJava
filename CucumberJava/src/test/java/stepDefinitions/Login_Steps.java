package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.Base.Hooks;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class Login_Steps {
    private WebDriver driver=getDriver();
    WebDriverWait wait =wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Given("Login page url")
    public void login_page_url() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }
    @When("I enter password  {string}")
    public void i_enter_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }
    @When("I click login button")
    public void i_click_login_button() throws InterruptedException {
        //driver.findElement().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login-button']"))).click();
    }

    @Then("alert should shown with {string} message")
    public void alert_should_shown_with_message(String expAlertMessage) throws InterruptedException {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        String alertMessage=alert.getText();
        Assert.assertEquals(alertMessage,expAlertMessage);
        alert.accept();
    }
    @Then("username and password field should be empty once the alert popup closed")
    public void username_and_password_field_should_be_empty_once_the_alert_popup_closed(){
        String username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='text']"))).getText();
        String password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).getText();
        Assert.assertEquals(username,"");
        Assert.assertEquals(password,"");
    }
}
