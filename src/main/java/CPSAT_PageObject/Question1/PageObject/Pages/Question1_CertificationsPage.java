package CPSAT_PageObject.Question1.PageObject.Pages;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * This class contains all the steps for Question 1 Certifications page
 */
@Slf4j
public class Question1_CertificationsPage extends CPSAT_UtilityFunctions {
    WebDriver webDriver;

    public Question1_CertificationsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Count the number of certification icons visible on the web page opened
     *
     * @param certificationsImage
     * @return urlOntheImage
     */
    public List<String> countTheNumberOfCertificationsIconsVisibleOnThePage(By certificationsImage) {

        waitUntilTheElementIsVisible(webDriver, certificationsImage);
        List<WebElement> iconsVisibleOnThePage = searchElementsByXpath(webDriver, certificationsImage);
        List<String> urlOntheImage = new ArrayList<String>();
        Assertions.assertThat(iconsVisibleOnThePage.size()).isEqualTo(12);
        for (int i = 0; i < iconsVisibleOnThePage.size(); i++) {
            urlOntheImage.add(iconsVisibleOnThePage.get(i).getAttribute("href"));
            log.info("The Icon " + iconsVisibleOnThePage.get(i).getAttribute("title") + " is pointing to " +
                    "the URL : " + iconsVisibleOnThePage.get(i).getAttribute("href"));
        }
        System.out.println();
        return urlOntheImage;
    }

    /**
     * Ensures the URL is working properly
     *
     * @param certificationsImage
     * @throws ProtocolException
     */
    public void confirmIfTheUrlIsWorkingOrNot(By certificationsImage) throws ProtocolException {
        List<String> urlList = this.countTheNumberOfCertificationsIconsVisibleOnThePage(certificationsImage);
        SoftAssertions softAssertions = new SoftAssertions();
        String urlType = null;
        HttpURLConnection httpURLConnection = null;
        for (int i = 0; i < urlList.size(); i++) {
            try {
                httpURLConnection = (HttpURLConnection) (new URL(urlList.get(i)).openConnection());

                httpURLConnection.setRequestMethod("HEAD");

                httpURLConnection.connect();

                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= 400) {
                    urlType = "Broken Link";
                } else {
                    urlType = "Valid Link";
                    System.out.println("The URL " + urlList.get(i) + " is a " + urlType + "");
                }
                softAssertions.assertThat(responseCode).as("The URL " + urlList.get(i) + " is a " + urlType + "").isNotEqualTo(400);

            } catch (MalformedURLException mex) {
                mex.printStackTrace();
            } catch (IOException iox) {
                iox.printStackTrace();
            }
        }
        softAssertions.assertAll();
    }

    /**
     * Takes screen shot and store that in a destination folder
     *
     * @param fileName
     * @throws IOException
     */

    /**
     * Hover on CP-CCT icon
     *
     * @param cpcctIcon
     */
    public void hoverOnCpcctIcon(By cpcctIcon) throws IOException, InterruptedException, AWTException {

        takeScreenShot(webDriver, "src/test/output/screenshots/Question1_Screenshots", "Screenshot" +
                " before hovering");
        Robot robot = new Robot();
        robot.setAutoDelay(1000);
        robot.mouseMove(440, 515);
        waitForParticularTime(2L);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(450, 495);
        waitForParticularTime(2L);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(445, 495);
        waitForParticularTime(1L);
        takeScreenShot(webDriver, "src/test/output/screenshots/Question1_Screenshots", "Screenshot" +
                " after hovering");

    }


}
