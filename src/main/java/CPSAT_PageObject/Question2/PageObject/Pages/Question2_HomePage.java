package CPSAT_PageObject.Question2.PageObject.Pages;


import CPSAT_Utilities.CPSAT_UtilityFunctions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains all the steps for Question 2 Home page
 */
@Slf4j
public class Question2_HomePage extends CPSAT_UtilityFunctions {

    WebDriver webDriver;

    public Question2_HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Get the advances,declines,unchanged values and print the minimum value
     * @param titles
     * @param counts
     * @throws InterruptedException
     */
    public void getAdvancesDeclinesUnchangedNumbersAndPrintTheMinimum(By titles, By counts) throws InterruptedException {
        waitUntilTheElementIsVisible(webDriver, titles);
//        waitUntilTheElementIsVisible(webDriver, counts);
        Map<String, Integer> titleAndCount = new HashMap<String, Integer>();
        List<WebElement> title = searchElementsByXpath(webDriver, titles);
        List<WebElement> count = searchElementsByXpath(webDriver, counts);
        for (int i = 0; i < title.size(); i++) {
            titleAndCount.put(title.get(i).getText(), Integer.parseInt(count.get(i).getText()));
        }
        System.out.println("" + titleAndCount);
        Integer countForMininumValue = Collections.min(titleAndCount.values());
        String titleForMinimumValue = null;
        for (Map.Entry<String, Integer> entry : titleAndCount.entrySet()) {
            if (countForMininumValue.equals(entry.getValue())) {
                titleForMinimumValue = entry.getKey();
            }
        }
        System.out.println("Minimum value = " + titleForMinimumValue + " " + countForMininumValue);
        log.info("Minimum value = " + titleForMinimumValue + " " + countForMininumValue);

    }

}
