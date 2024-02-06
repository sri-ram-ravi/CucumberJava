package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login_Steps {
    private WebDriver webDriver;
    private WebDriverWait wait;
    Alert alert;
    @Before("@login")
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        wait=new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }
    @After("@login")
    public void tearDownDriver(){
        webDriver.quit();
    }

    @Given("Login page url")
    public void login_page_url() {
        webDriver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        webDriver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }
    @When("I enter password  {string}")
    public void i_enter_password(String password) {
        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }
    @When("I click login button")
    public void i_click_login_button() {
        webDriver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @Then("alert should shown with {string} message")
    public void alert_should_shown_with_message(String expAlertMessage) {
        String alertMessage=webDriver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage,expAlertMessage);
        webDriver.switchTo().alert().accept();
    }
    @Then("username and password field should be empty once the alert popup closed")
    public void username_and_password_field_should_be_empty_once_the_alert_popup_closed() {
        String username=webDriver.findElement(By.xpath("//input[@id='text']")).getText();
        String password=webDriver.findElement(By.xpath("//input[@id='password']")).getText();
        Assert.assertEquals(username,"");
        Assert.assertEquals(password,"");
    }
}
