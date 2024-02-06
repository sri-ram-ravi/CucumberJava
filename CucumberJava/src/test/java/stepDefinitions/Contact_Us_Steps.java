package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver=new ChromeDriver(chromeOptions);
    }

    @After
    public void tearDownDriver(){
        driver.quit();
    }

    @Given("Go to the webdriver university contact us page")
    public void go_to_the_webdriver_university_contact_us_page() {
        System.out.println("step 1-ku");
    }
    @When("I enter first name")
    public void i_enter_first_name() {
        System.out.println("step 2");
    }
    @When("I enter last name")
    public void i_enter_last_name() {
        System.out.println("step 3");
    }
    @When("I enter email address")
    public void i_enter_email_address() {
        System.out.println("step 4");
    }
    @When("I enter comment")
    public void i_enter_comment() {
        System.out.println("step 5");
    }
    @When("I click submit")
    public void i_click_submit() {
        System.out.println("step 6");
    }
    @Then("I should see {string}")
    public void i_should_see(String string) {
        System.out.println("step 7");
    }
}
