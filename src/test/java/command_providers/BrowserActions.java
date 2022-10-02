package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
public class BrowserActions {
    public WebDriver driver;

    public BrowserActions(WebDriver driver){

        this.driver = driver;
    }

    public BrowserActions openBrowser(String url){
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='cl-dialog-close']//*[name()='svg']")).click();
        return this;
    }

    public BrowserActions closeBrowser(){
        driver.quit();
        return this;
    }

    public String captureTitle(){
        return driver.getTitle();
    }
}
