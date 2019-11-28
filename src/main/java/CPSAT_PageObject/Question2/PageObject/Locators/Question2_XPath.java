package CPSAT_PageObject.Question2.PageObject.Locators;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;

/**
 * This class contains the locators(xpath's) for Question 2
 */
public class Question2_XPath {

    public static final By advanceTab_titles=By.xpath("//ul[@class='advanceTab']//p");
    public static final By advanceTab_counts=By.xpath("//ul[@class='advanceTab']//span");
    public static final By marketWatchAdvance = By.cssSelector("#advance.span");
}
