package CPSAT_PageObject.Question6.PageObject.Locators;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;

/**
 * This class contains the locators(xpath's) for Question 6
 */
public class Question6_XPath {
    public static final By liveMarketTab = By.xpath("//a[contains(text(),'Live Market')]");
    public static final By topTenGainersLosersTab = By.xpath("//a[contains(text(),'Top Ten Gainers / Losers')]");
    public static final By gainersTab = By.xpath("//a[text()='Gainers']");
    public static final By losersTab = By.xpath("//a[text()='Losers']");
    public static final By gainersTableHeader=By.xpath("//table[@id='topGainers']/child::tbody/tr/th");
    public static final By losersTableHeader=By.xpath("//table[@id='topLosers']/child::tbody/tr/th");
    public static final By gainersTableData=By.xpath("//table[@id='topGainers']/child::tbody/tr/child::th|//table[@id='topGainers']/child::tbody/tr/following-sibling::tr/td");
    public static final By losersTableData=By.xpath("//table[@id='topLosers']/child::tbody/tr/child::th|//table[@id='topLosers']/child::tbody/tr/following-sibling::tr/td");
    public static final By dateAndTime=By.xpath("//span[@id='dataTime']");
    public static final By refreshGif=By.xpath("//input[@src='/common/images/icon_refresh.gif']");


}
