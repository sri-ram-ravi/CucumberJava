package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page {
    private WebDriver driver;
    public By username=By.xpath("//input[@id='text']");
    public By password=By.xpath("//input[@id='password']");
    public By login=By.xpath("//button[@id='login-button']");
    public void setUsername(String UserName){
        driver.findElement(username).sendKeys(UserName);
    }
    public void setPassword(String Password){
        driver.findElement(password).sendKeys(Password);
    }
    public void clickLogin(){
        driver.findElement(login).click();
    }
}
