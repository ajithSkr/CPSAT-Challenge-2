package CPSAT_Utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * This class contains all the utility functions for chrome and firefox driver
 */

public class CPSAT_UtilityFunctions {

    /**
     * Read the data stored in properties file
     *
     * @param fieldName
     * @return fieldValue
     * @throws IOException
     */
    public static String getPropertyValue(String fieldName) throws IOException {
        Properties properties = new Properties();
        String fieldValue = null;
        File file = new File("src/test/resources/config.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        fieldValue = properties.getProperty(fieldName);
        if (fieldValue == null) {
            System.err.println("Failed to fetch '" + fieldName + "' from " + file.getAbsolutePath() + "");
            System.exit(0);
        }
        return fieldValue;
    }

    /**
     * Wait for the particular time that can be defined depending upon the scenario
     *
     * @param time
     * @throws InterruptedException
     */
    public static void waitForParticularTime(Long time) throws InterruptedException {
        time = time * 1000;
        Thread.sleep(time);
    }

    /**
     * Wait implicitly for all the conditions
     *
     * @param webDriver
     * @param time
     */
    public static void implicityWait(WebDriver webDriver, Long time) {
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     * Wait explicitly for certain conditions
     *
     * @param webDriver
     * @param xpath
     */
    public static void waitUntilTheElementIsVisible(WebDriver webDriver, By xpath) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    /**
     * Wait until the element is ready for click
     *
     * @param webDriver
     * @param xpath
     */
    public static void waitUntilTheElementIsClickable(WebDriver webDriver, By xpath) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    /**
     * Search the elements through XPATH
     *
     * @param webDriver
     * @param xpath
     * @return webElement
     */
    public static WebElement searchElementByXpath(WebDriver webDriver, By xpath) {
        WebElement webElement = webDriver.findElement(xpath);
        return webElement;
    }


    /**
     * Search all the elements present in the page through XPATH
     *
     * @param webDriver
     * @param xpath
     * @return webElements
     */
    public static List<WebElement> searchElementsByXpath(WebDriver webDriver, By xpath) {
        List<WebElement> webElement = webDriver.findElements(xpath);
        return webElement;
    }

    /**
     * Click the elements through XPATH
     *
     * @param webDriver
     * @param xpath
     */
    public static void clickElementByXpath(WebDriver webDriver, By xpath) {
        webDriver.findElement(xpath).click();
    }

    /**
     * Feed data into the fields through XPATH
     *
     * @param webDriver
     * @param xpath
     * @param text
     */
    public static void sendKeysByXpath(WebDriver webDriver, By xpath, String text) {
        webDriver.findElement(xpath).sendKeys(text);
    }


    /**
     * Scroll the web page until the elements visible
     *
     * @param webDriver
     * @param webElement
     * @throws InterruptedException
     */
    public static void scrollElementByXpath(WebDriver webDriver, WebElement webElement) throws InterruptedException {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitForParticularTime(5L);
    }

    /**
     * Scroll to the particular area vertically
     *
     * @param webDriver
     * @param pixels
     */
    public static void scrollToRequiredArea(WebDriver webDriver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }


    /**
     * Place the cursor on the element
     *
     * @param webDriver
     * @param xpath
     */
    public static void hoverOnTheElement(WebDriver webDriver, By xpath) throws AWTException {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(searchElementByXpath(webDriver, xpath)).clickAndHold();
        actions.release();
        actions.perform();

    }

    /**
     * Perform context click on the element
     *
     * @param webDriver
     * @param xpath
     * @throws InterruptedException
     */
    public static void contextClick(WebDriver webDriver, By xpath) {
        Actions actions = new Actions(webDriver);
        WebElement locateElement = webDriver.findElement(xpath);
        actions.contextClick(locateElement).perform();

    }

    /**
     * Takes screen shots and store that in a destination folder
     *
     * @param webDriver
     * @param filePath
     * @param fileName
     * @throws IOException
     */
    public static void takeScreenShot(WebDriver webDriver, String filePath, String fileName) throws IOException {
        File directory = new File(filePath);
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(directory + "/" + fileName + ".png");
        FileUtils.copyFile(sourceFile, destinationFile);
    }

    /**
     * Reads data from the excel sheet
     * @return
     * @throws IOException
     */

    public static ArrayList<Object[]> readExcelData(String filePath) throws IOException {
        ArrayList<Object[]> userData = new ArrayList<Object[]>();
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = null;
            Iterator iterator = sheet.rowIterator();
            int rownum = 0;
            while (iterator.hasNext()) {
                row = (XSSFRow) iterator.next();
                if (rownum > 0) {
                    String product = row.getCell(0).toString();
                    Object data[] = {product};
                    userData.add(data);
                }
                rownum++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }


}
