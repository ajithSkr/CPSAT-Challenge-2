package CPSAT_PageObject.Question4.PageObject.Pages;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class contains the all steps for Question 4 Live market page
 */
public class Question4_LiveMarketPage extends CPSAT_UtilityFunctions {

    WebDriver webDriver;

    public Question4_LiveMarketPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Fetches the expected field names and print on the console
     *
     * @param fieldName
     * @param tableData
     */
    public void fetchAndPrintTheValuesOnTheConsole(String fieldName, By tableData) {
        List<WebElement> tableValues = CPSAT_UtilityFunctions.searchElementsByXpath(webDriver, tableData);
        tableValues.addAll(CPSAT_UtilityFunctions.searchElementsByXpath(webDriver, tableData));
        for (int i = 0; i < tableValues.size(); i++) {
            if (tableValues.get(i).getText().contains(fieldName)) {
                System.out.println(fieldName + " = " + tableValues.get(i).getText().replace(fieldName, "").replaceAll("(?m)^[ " +
                        "\t]*\r?\n", "").replace("\n", ", "));
            }

        }
    }

}
