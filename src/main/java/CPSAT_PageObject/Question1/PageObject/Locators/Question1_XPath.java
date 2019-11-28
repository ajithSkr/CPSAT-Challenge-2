package CPSAT_PageObject.Question1.PageObject.Locators;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;

/**
 * This class contains the locators(xpath's) for Question 1
 */
public class Question1_XPath {
    public static final By certificationsMenuItem = By.xpath("//ul[@class='menu']//a[@href='certifications.html']");
    public static final By certificationsIcons=By.xpath("//map[@name='image-map']//area[@target='_self']");
    public static final By ataImage=By.xpath("//img[@src='./images/ATA_Certifications.jpg']");
    public static final By cpcctIcon=By.xpath("//area[@title='CP-CCT']");

}
