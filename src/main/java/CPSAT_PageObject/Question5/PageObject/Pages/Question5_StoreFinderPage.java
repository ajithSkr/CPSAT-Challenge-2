package CPSAT_PageObject.Question5.PageObject.Pages;


import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * This class contains all the steps for the store finder page
 */

public class Question5_StoreFinderPage extends CPSAT_UtilityFunctions {


    WebDriver webDriver;

    public Question5_StoreFinderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Prints the cities name available in the search city field
     *
     * @param searchCityField
     * @param allCitiesOptions return allCitiesName
     */
    public List<WebElement> printTheCitiesNameThatAvailableInFindStoresInYourCity(By searchCityField,
                                                                                  By allCitiesOptions) throws InterruptedException {
        waitForParticularTime(2L);
        clickElementByXpath(webDriver, searchCityField);
        List<WebElement> allCitiesName = new LinkedList<WebElement>();
        allCitiesName.addAll(searchElementsByXpath(webDriver, allCitiesOptions));
        System.out.println("*** All available cities ***");
        System.out.println();
        for (int i = 0; i < allCitiesName.size(); i++) {
            System.out.println(allCitiesName.get(i).getText());
        }
        return allCitiesName;
    }

    /**
     * Assert the Agra,Bhopal,Mysore are available in find stores in your city
     *
     * @param allCitiesName
     * @throws InterruptedException
     */
    public void assertTheAgraBhopalMysoreAreAvailableInFindStoresInYourCity(List<WebElement> allCitiesName) throws InterruptedException {
        List<String> allCities = new LinkedList<String>();
        for (int i = 0; i < allCitiesName.size(); i++) {
            allCities.add(allCitiesName.get(i).getText());
        }
        waitForParticularTime(2L);
        String agra = "Agra";
        String bhopal = "Bhopal";
        String mysore = "Mysore";
        Assert.assertTrue(allCities.contains(agra));
        Assert.assertTrue(allCities.contains(bhopal));
        Assert.assertTrue(allCities.contains(mysore));

    }

    /**
     * To print the page title in console
     */
    public void printThePageTitleInConsole()
    {
        System.out.println();
        System.out.println("*** Page title ***");
        System.out.println();
        System.out.println(""+"\""+webDriver.getTitle()+"\"");
    }

}
