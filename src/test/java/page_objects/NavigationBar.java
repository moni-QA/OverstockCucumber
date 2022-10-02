package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {

    private  final By Account = By.xpath("//button[@name='Account']");
    private  final By CreateAccountLik = By.xpath("//a[@data-tid='HEAD:USERBAR:ACCOUNT:CREATEACCOUNT']");
    public WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);
    public NavigationBar(WebDriver driver){

        this.driver= driver;
    }
    public NavigationBar mouseHoverToAccount(){
        LOGGER.debug("Mouse Hover to the Account Link");
        ActOn.element(driver,Account).mouseHover();
        return this;
    }
    public NavigationBar navigateToCreateAccount(){
        LOGGER.debug("Clicking on the Create an Account  link");
        ActOn.element(driver,CreateAccountLik).click();
        return this;
    }

}
