package CPSAT_PageObject.Question4.PageObject.Pages;


import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * This class contains the all steps for Question 4 Home Page
 */
public class Question4_HomePage extends CPSAT_UtilityFunctions {
    WebDriver webDriver;

    public Question4_HomePage(WebDriver webDriver)
    {
        this.webDriver=webDriver;
    }
    /**
     * To Search the company name and find the result
     * @param searchField
     * @param companyName
     * @throws InterruptedException
     */
    public void enterTheCompanyName(By searchField,String companyName) throws InterruptedException {
        waitUntilTheElementIsVisible(webDriver,searchField);
        sendKeysByXpath(webDriver,searchField,companyName);
        waitForParticularTime(3L);
        searchElementByXpath(webDriver,searchField).sendKeys(Keys.ENTER);
        waitForParticularTime(4L);

    }

}
