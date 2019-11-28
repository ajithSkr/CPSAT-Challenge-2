package CPSAT_PageObject.Question5.PageObject.Locators;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * This class contains the locators(xpath's) for Question 5
 */
public class Question5_XPath {

    public static final By nextButton = By.xpath("//div[@class='dy-container-437876 slick-initialized slick-slider " +
            "slick-dotted']//div[@class='dy-slick-arrow dy-next-arrow slick-arrow']");
    public static final By allBannerSlides=By.xpath("//div[@class='slick-track']//div[contains(@id,'slick-slide')]");
    public static final By currentSlide = By.xpath("//div[@class='slick-track']//div[contains(@id,'slick-slide')" +
            "][contains(@class,'slick-slide slick-current')]");
    public static final By menTab = By.xpath("//a[@title='MEN']");
    public static final By mensFrangnance = By.xpath("(//a[@title='MEN']//following-sibling::div//div[@class='lvl2" +
            "-container']//ul[@class='lvl2']/child::li)[6]");
    public static final By mensFragnanceElements = By.xpath("//a[@title='MEN']/following::div/child::ul//a[text()" +
            "=\"Men's Fragrance\"]/following-sibling::div/child::ul//li//div//ul//li//span | " +
            "//a[@title='MEN']/following::div/child::ul//a[text()=\"Men's " +
            "Fragrance\"]/following-sibling::div/child::ul//li//div//ul//li//span/following-sibling::ul//li");
    public static final By allStoresLink = By.xpath("//ul[@class='text-right']//a[contains(text(),'All Stores')]");
    public static final By selectCityField = By.xpath("//select[@id='city-name']");
    public static final By allCitiesOptions = By.xpath("//select[@id='city-name']/option");


}
