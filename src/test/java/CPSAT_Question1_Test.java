import CPSAT_PageObject.Question1.PageObject.Locators.Question1_XPath;
import CPSAT_PageObject.Question1.PageObject.Pages.Question1_CertificationsPage;
import CPSAT_PageObject.Question1.PageObject.Pages.Question1_HomePage;
import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * This class contains the test methods for Question 1
 */
public class CPSAT_Question1_Test extends Question1_XPath {

    static WebDriver webDriver;
    static Question1_HomePage homePage;
    static Question1_CertificationsPage certificationsPage;

    @BeforeClass
    public static void preSetup() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get(CPSAT_UtilityFunctions.getPropertyValue("question_1_url"));
        CPSAT_UtilityFunctions.implicityWait(webDriver, 15L);
        homePage = new Question1_HomePage(webDriver);
        certificationsPage = new Question1_CertificationsPage(webDriver);
        File directory = new File("src/test/output/screenshots");
        FileUtils.cleanDirectory(directory);

    }

    @Test
    public void cpsatQuestion1Test() throws IOException, InterruptedException, AWTException {
        homePage.clickOnCertificationMenuItem(certificationsMenuItem);
        certificationsPage.countTheNumberOfCertificationsIconsVisibleOnThePage(certificationsIcons);
        certificationsPage.confirmIfTheUrlIsWorkingOrNot(certificationsIcons);
        certificationsPage.hoverOnCpcctIcon(cpcctIcon);


    }


    @AfterClass
    public static void tearDown() throws InterruptedException {

        webDriver.quit();
    }

}