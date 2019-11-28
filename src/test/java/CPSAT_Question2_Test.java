import CPSAT_PageObject.Question2.PageObject.Locators.Question2_XPath;
import CPSAT_PageObject.Question2.PageObject.Pages.Question2_HomePage;
import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This class contains the test methods for Question 2
 */
public class CPSAT_Question2_Test {

    static WebDriver webDriver;
    Question2_HomePage homePage;

    @BeforeClass
    public void preSetup() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get(CPSAT_UtilityFunctions.getPropertyValue("question_2_url"));
        CPSAT_UtilityFunctions.waitForParticularTime(5L);
        homePage = new Question2_HomePage(webDriver);

    }

    @Test
    public void cpsatQuestion2Test() throws InterruptedException {
        homePage.getAdvancesDeclinesUnchangedNumbersAndPrintTheMinimum(Question2_XPath.advanceTab_titles,
                Question2_XPath.advanceTab_counts);
        homePage.getAdvancesDeclinesUnchangedNumbersAndPrintTheMinimum(Question2_XPath.advanceTab_titles,
                Question2_XPath.marketWatchAdvance);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }


}
