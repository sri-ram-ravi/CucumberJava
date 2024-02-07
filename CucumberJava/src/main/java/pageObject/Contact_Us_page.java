package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contact_Us_page {
    private WebDriver driver;

    public By firstName= By.xpath("//input[@name='first_name']");
    public By lastName=By.xpath("//input[@name='last_name']");
    public By emailAddress=By.xpath("//input[@name='email']");
    public By comment=By.xpath("//textarea[@name='message']");
    public By submitButton=By.xpath("//input[@value='SUBMIT']");
    public By resetButton=By.xpath("//input[@value='RESET']");
    public Contact_Us_page(WebDriver driver) {
        this.driver=driver;
    }

    public void setFirstName(String FirstName) {
        driver.findElement(firstName).sendKeys(FirstName);
    }

    public void setLastName(String LastName) {
        driver.findElement(lastName).sendKeys(LastName);
    }

    public void setEmailAddress(String EmailAddress) {
        driver.findElement(emailAddress).sendKeys(EmailAddress);
    }

    public void setComment(String Comment) {
        driver.findElement(comment).sendKeys(Comment);
    }

    public void setSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void setResetButton() {
        driver.findElement(resetButton).click();
    }
}
