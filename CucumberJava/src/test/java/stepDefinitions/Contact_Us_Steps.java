package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.Contact_Us_page;
import stepDefinitions.Base.Hooks;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class Contact_Us_Steps {

    private WebDriver driver=getDriver();
    WebDriverWait wait =wait = new WebDriverWait(driver, Duration.ofSeconds(20));

   Contact_Us_page contactUsPage=new Contact_Us_page(driver);

    @Given("Go to the webdriver university contact us page")
    public void go_to_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter first name {string}")
    public void i_enter_first_name(String firstname) {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
        contactUsPage.setFirstName(firstname);
    }
    @When("I enter last name {string}")
    public void i_enter_last_name(String lastname) {
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
        contactUsPage.setLastName(lastname);
    }
    @When("I enter email address {string}")
    public void i_enter_email_address(String email) {
        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        contactUsPage.setEmailAddress(email);
    }
    @When("I enter comment {string}")
    public void i_enter_comment(String comment) {
        //driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
        contactUsPage.setComment(comment);
    }
    @When("I click submit")
    public void i_click_submit() {
        //driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        contactUsPage.setSubmitButton();
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
        contactUsPage.setResetButton();
    }

    @Then("first name should be empty")
    public void first_name_should_be_empty() {
        String emptyFirstName=driver.findElement(contactUsPage.firstName).getAttribute("value");
        Assert.assertEquals(emptyFirstName,"");
    }
    @Then("last name should be empty")
    public void last_name_should_be_empty() {
        String emptyLastName=driver.findElement(contactUsPage.lastName).getAttribute("value");
        Assert.assertEquals(emptyLastName,"");
    }
    @Then("email should be empty")
    public void email_should_be_empty() {
        String emptyEmail=driver.findElement(contactUsPage.emailAddress).getAttribute("value");
        Assert.assertEquals(emptyEmail,"");
    }
    @Then("comment should be empty")
    public void comment_should_be_empty() {
       String emptyMessage=driver.findElement(contactUsPage.comment).getAttribute("value");
       Assert.assertEquals(emptyMessage,"");
    }

}
