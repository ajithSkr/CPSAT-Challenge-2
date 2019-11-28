package CPSAT_PageObject.Question6.PageObject.Pages;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * This class contains all the steps for the Question 6 home page
 */
public class Question6_HomePage extends CPSAT_UtilityFunctions {
    WebDriver webDriver;

    public Question6_HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Hover on Live market tab
     *
     * @param liveMarketTab
     */
    public void hoverOnTheLiveMarketTab(By liveMarketTab) {
        waitUntilTheElementIsVisible(webDriver, liveMarketTab);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(searchElementByXpath(webDriver, liveMarketTab)).perform();

    }

    /**
     * Click on the Top Ten Gainers Losers Option
     *
     * @param topTenGainersLosers
     */
    public void clickOnTopTenGainersLosersOption(By topTenGainersLosers) {
        waitUntilTheElementIsVisible(webDriver, topTenGainersLosers);
        clickElementByXpath(webDriver, topTenGainersLosers);
    }


}
