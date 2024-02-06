package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Contact_Us_Steps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDownDriver(){
        driver.quit();
    }

    @Given("Go to the webdriver university contact us page")
    public void go_to_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter first name {string}")
    public void i_enter_first_name(String firstname) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
    }
    @When("I enter last name {string}")
    public void i_enter_last_name(String lastname) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
    }
    @When("I enter {int} email address {string}")
    public void i_enter_email_address(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }
    @When("I enter comment {string}")
    public void i_enter_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }
    @When("I click submit")
    public void i_click_submit() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedThankYouMessage) {
        String thankYouMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='contact_reply']/h1"))).getText();
        Assert.assertEquals(thankYouMessage,expectedThankYouMessage);
    }
    /* Reset Feature*/
    @When("I click reset")
    public void i_click_reset() {
            driver.findElement(By.xpath("//input[@value='RESET']")).click();
    }

    @Then("first name should be empty")
    public void first_name_should_be_empty() {
        String emptyFirstName=driver.findElement(By.xpath("//input[@name='first_name']")).getAttribute("value");
        Assert.assertEquals(emptyFirstName,"");
    }
    @Then("last name should be empty")
    public void last_name_should_be_empty() {
        String emptyLastName=driver.findElement(By.xpath("//input[@name='last_name']")).getAttribute("value");
        Assert.assertEquals(emptyLastName,"");
    }
    @Then("email should be empty")
    public void email_should_be_empty() {
        String emptyEmail=driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
        Assert.assertEquals(emptyEmail,"");
    }
    @Then("comment should be empty")
    public void comment_should_be_empty() {
       String emptyMessage=driver.findElement(By.xpath("//textarea[@name='message']")).getAttribute("value");
       Assert.assertEquals(emptyMessage,"");
    }

}
