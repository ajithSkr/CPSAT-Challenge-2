package CPSAT_PageObject.Question5.PageObject.Pages;


import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * This class contains all the steps for Question 5 Home page
 */
public class Question5_HomePage extends CPSAT_UtilityFunctions {
    WebDriver webDriver;

    public Question5_HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Clicks the banner until the image repeats
     *
     * @param allBannerSlide
     * @param currentSlide
     * @param nextButton
     * @throws InterruptedException
     * @throws IOException
     */
    public void clickOnTheBannerSliderForTheNumberOFTimesTillTheBannerGetsRepeated(By allBannerSlide,By nextButton, By currentSlide) throws InterruptedException, IOException {
        waitForParticularTime(2L);
        String imageBanner = searchElementByXpath(webDriver, currentSlide).getAttribute("id");
        System.out.println("Slide while page opens "+imageBanner);
        clickElementByXpath(webDriver,nextButton);
        for (int i = 0; i < searchElementsByXpath(webDriver, allBannerSlide).size(); i++) {
            System.out.println("Current slide "+searchElementByXpath(webDriver, currentSlide).getAttribute("id"));
            if (searchElementByXpath(webDriver, currentSlide).getAttribute("id").toLowerCase().equals(imageBanner.toLowerCase())) {
                System.out.println("Success "+searchElementByXpath(webDriver, currentSlide).getAttribute("id"));
                break;
            } else {
                waitForParticularTime(1L);
                clickElementByXpath(webDriver, nextButton);
            }
        }


    }

    /**
     * Print all the accessories under men section Fragrance
     *
     * @param mensTab
     * @param mensFragnance
     * @param mensFragnanceElements
     * @throws InterruptedException
     */
    public void printAllTheAccessoriesUnderMenSectionMenFragnance(By mensTab, By mensFragnance,
                                                                  By mensFragnanceElements) throws InterruptedException {
        waitForParticularTime(2L);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(searchElementByXpath(webDriver, mensTab)).perform();
        waitForParticularTime(3L);
        actions.moveToElement(searchElementByXpath(webDriver, mensFragnance)).perform();
        waitForParticularTime(3L);
        System.out.println("*** The Accessories under the Men's Fragrance ***");
        System.out.println();
        for (int i = 0; i < (searchElementsByXpath(webDriver, mensFragnanceElements).size()); i++) {
            System.out.println(searchElementsByXpath(webDriver,
                    mensFragnanceElements).get(i).getText());
        }
        System.out.println();
    }

    /**
     * Click on all stores link
     * @param allStoresLink
     */
    public void clickOnAllStoresLink(By allStoresLink) {
        waitUntilTheElementIsClickable(webDriver, allStoresLink);
        clickElementByXpath(webDriver, allStoresLink);
    }
}

