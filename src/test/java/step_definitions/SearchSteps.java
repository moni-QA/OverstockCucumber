package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;
import java.time.Duration;

public class SearchSteps {
    private static final By SearchText = By.xpath("//input[@placeholder='Search... everything you find ships for free']");
    private static final By SearchButton= By.xpath("//button[@aria-label='search']");
    private static final By SearchHistory= By.xpath("//h1[normalize-space()='Mattresses']");
    private static final By SearchError= By.xpath("//h1[normalize-space()='No Results']");


    private Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    WebDriver driver = Hooks.driver;

    @Given("^a user is on the overstock home page to purchase some items$")
    public void navigateToOverstockHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("OverstockWebURL"));
        LOGGER.info("User is on the overstock home Page");
    }
    @When("^user enters \"(.+?)\" into the search bar$")
    public void enterCredentials(String text){
        ActOn.element(driver, SearchText).setValue(text);
        LOGGER.info("User enters text");
    }
    @And("^click on search button$")
    public void clickOnSearchButton(){
        ActOn.element(driver,SearchButton).click();
        LOGGER.info("click on search button");
    }

    @Then("^search history should be displayed$")
    public void displaySearchHistory(){
        AssertThat.elementAssertions(driver,SearchHistory).elementIsDisplayed();
        LOGGER.info("search history should be displayed");
    }
    @Then("^search history should not be displayed$")
    public void displaySearchError(){
        AssertThat.elementAssertions(driver,SearchError).elementIsDisplayed();
        LOGGER.info("search history should not be displayed");
    }


}
