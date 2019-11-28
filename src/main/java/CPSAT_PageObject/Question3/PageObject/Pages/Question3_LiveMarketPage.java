package CPSAT_PageObject.Question3.PageObject.Pages;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

/**
 * This class contains the all steps for Question 3 Live market page
 */

public class Question3_LiveMarketPage extends CPSAT_UtilityFunctions {

    WebDriver webDriver;

    public Question3_LiveMarketPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Fetches the expected field names and print on the console
     * @param fieldName
     * @param tableData
     */
    public void fetchAndPrintTheValuesOnTheConsole(String fieldName, By tableData) {
        List<WebElement> tableValues = new LinkedList<WebElement>();
        tableValues.addAll(CPSAT_UtilityFunctions.searchElementsByXpath(webDriver, tableData));
        for (int i = 0; i < tableValues.size(); i++) {
            if (tableValues.get(i).getText().contains(fieldName)) {
                System.out.println(fieldName + " = " + tableValues.get(i).getText().replace(fieldName, "").replaceAll("(?m)^[ " +
                        "\t]*\r?\n", "").replace("\n", ", "));

            }

        }
    }


}
