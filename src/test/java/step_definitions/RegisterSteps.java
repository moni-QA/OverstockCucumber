package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page_objects.NavigationBar;
import utilities.ReadConfigFiles;

import java.time.Duration;
public class RegisterSteps {
    private static final By Email = By.id("register-email");
    private static   final By Password = By.id("register-password");
    private static final By CreateAccount= By.xpath("//button[@class='cl-button cl-button-lg cl-button-secondary']");
    private static final By InvalidEmail= By.xpath("//*[@id='register-form']/div[1]/div[2]");
    private static final By InvalidPassword = By.xpath("//*[@id='register-form']/div[2]/div/div[2]");
    private Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    // Precondition
    @Given("^a user is on the home page$")
    public void navigateToHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("OverstockWebURL"));
        LOGGER.info("User is on the home Page");
    }
    @And("^user navigate to Create Account page$")
    public void navigateToCreateAnAccountPage() {
        new NavigationBar(driver)
                .mouseHoverToAccount()
                .navigateToCreateAccount();
        LOGGER.info("Navigated to CreateAccount Page");
    }
    // Main Action
    @When("^user enters email \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String email, String password) {
        driver.switchTo().frame("loginIframe");
        ActOn.element(driver, Email).setValue(email);
        ActOn.element(driver, Password).setValue(password);
        LOGGER.info("User has entered credentials");
    }
    @And("^click on create account button$")
    public void clickOnCreateAccount(){
        ActOn.element(driver,CreateAccount).click();
        ActOn.wait(driver, CreateAccount).waitForElementToBeVisible();
        LOGGER.info("User click on the create account button");
    }
    @Then("^user is navigated to home page$")
    public void validateUserCreatedAccountSuccessfully(){
        String actualUrl= "https://www.overstock.com/";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        LOGGER.info("User is on the overstock home page");
    }
    @Then("^user is failed to create account for invalid email$")
    public void validateUserIsCanNotCreateAccount() {
        AssertThat.elementAssertions(driver, InvalidEmail).elementIsDisplayed();
        LOGGER.info("User is still on the register page");
    }
    @Then("^user is failed to create account for invalid password$")
    public void validateUserIsFailedToCreateAccount() {
        AssertThat.elementAssertions(driver, InvalidPassword).elementIsDisplayed();
        LOGGER.info("User is still on the register page");
    }
}
