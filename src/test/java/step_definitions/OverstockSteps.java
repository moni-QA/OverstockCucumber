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
import utilities.ReadConfigFiles;
import java.time.Duration;

public class OverstockSteps {
    private static final By Furniture= By.linkText("Furniture");
    private static final By TVStand =By.xpath("//a[@aria-label='TV Stands']");
    private static final By TVStandHome= By.xpath("//h1[normalize-space()='TV Stands & Entertainment Centers']");
    private static final By TVStandCard=By.xpath("//*[@id='1']/article[6]");
    private static final By TVStandTypes= By.xpath("//*[@id='rugsStoreHub']/div/section[1]/ul/li/div[3]");
    private static final By TVStandFilter= By.xpath("//h1[normalize-space()='Corner TV Stands']");
    private static final By ShippingLink = By.xpath("//*[@id='inViewCambar']/span/span/div[3]");
    private static final By ShippingInformation = By.xpath("//h3[normalize-space()='Free Shipping Details']");
    private static final By CartLink = By.xpath("//a[@href='/cart']");
    private static final By ShoppingLink = By.xpath("//a[@id='stationaryButtonDesktop']");
    private Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    WebDriver driver = Hooks.driver;

    @Given("^a user is on the overstock home page$")
    public void navigateToOverstockHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("OverstockWebURL"));
        LOGGER.info("User is on the overstock home Page");
    }
    @And("^user navigate to Furniture Page$")
    public void navigateToFurniturePage(){
        ActOn.element(driver,Furniture).mouseHover();
        LOGGER.info("user navigate to Furniture Page");
    }
    @When("^user click on TV Stand link$")
    public void clickOnTVStandLink(){
        ActOn.element(driver,TVStand).click();
        LOGGER.info("user click on TV Stand link");
    }

    @And("^user perform required steps to filtering product$")
    public void clickOnTVStandTypes(){
        ActOn.element(driver,TVStandTypes).click();
        LOGGER.info("user perform required steps to filtering product ");
    }
    @And("^user click on shipping link$")
    public void clickOnShippingLink(){
        ActOn.element(driver,ShippingLink).click();
        LOGGER.info("click on Shipping Link");
    }
    @Then("^user navigate to TVStand Page$")
    public void navigateToTVStandHomePage(){
        AssertThat.elementAssertions(driver, TVStandHome).elementIsDisplayed();
        LOGGER.info("user navigate to TV Stand Page");
    }
    @Then("^user can see the card of single product$")
    public void validateCardOfTVStand(){
        AssertThat.elementAssertions(driver,TVStandCard).elementIsDisplayed();
        LOGGER.info("user can see the cards of product");
    }
    @Then("^user can see the  product based on filtering$")
    public void validateFilteringProduct(){
        AssertThat.elementAssertions(driver,TVStandFilter).elementIsDisplayed();
        LOGGER.info("user can see the  product based on filtering");
    }
    @Then("^user can see the details information of shipping$")
    public void displayShippingInformation(){
        AssertThat.elementAssertions(driver,ShippingInformation).elementIsDisplayed();
        LOGGER.info("user can see the details information of shipping");
    }
    @And("^user navigate to Cart Page$")
    public void clickOnCartPageLink(){
        ActOn.element(driver,CartLink).click();
        LOGGER.info("user navigate to Cart Page");
    }
    @When("^user click on Continue Shopping$")
    public void clickOnProductLink(){
        ActOn.element(driver,ShoppingLink).mouseHover();
        LOGGER.info("user click on Continue Shopping");
    }

    @Then("^user can navigate to cart page$")
    public void navigateToCartPage(){
        String actualUrl= "https://www.overstock.com/cart";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        LOGGER.info("user can navigate to cart page");
    }


}

