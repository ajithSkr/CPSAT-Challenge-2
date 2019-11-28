package CPSAT_PageObject.Question3.PageObject.Locators;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;

/**
 * This class contains the locators(xpath's) for Question 3
 */
public class Question3_XPath {

    public static By seachField = By.xpath("//input[@id='keyword']");
    public static By tableData=By.xpath("//div[@class='leftTableData']//ul//li");


}
