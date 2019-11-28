package CPSAT_PageObject.Question3.PageObject.Pages;


import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * This class contains the all steps for Question 3 Home Page
 */
public class Question3_HomePage extends CPSAT_UtilityFunctions {
    WebDriver webDriver;

    public Question3_HomePage(WebDriver webDriver)
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
