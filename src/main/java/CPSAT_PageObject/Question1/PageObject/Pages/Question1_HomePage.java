package CPSAT_PageObject.Question1.PageObject.Pages;


import CPSAT_Utilities.CPSAT_UtilityFunctions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class contains all the steps for Question 1 Home page
 */

@Slf4j
public class Question1_HomePage extends CPSAT_UtilityFunctions{

    WebDriver webDriver;

    public Question1_HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Click on the certification menu item through xpath
     *
     * @param certificationsMenuItem
     */
    public void clickOnCertificationMenuItem(By certificationsMenuItem) {
        waitUntilTheElementIsClickable(webDriver,certificationsMenuItem);
        clickElementByXpath(webDriver, certificationsMenuItem);
        log.info("This is done ");

    }


}
