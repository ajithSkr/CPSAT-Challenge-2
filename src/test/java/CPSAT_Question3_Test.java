import CPSAT_PageObject.Question3.PageObject.Locators.Question3_XPath;
import CPSAT_PageObject.Question3.PageObject.Pages.Question3_HomePage;
import CPSAT_PageObject.Question3.PageObject.Pages.Question3_LiveMarketPage;
import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This class contains the test methods for Question 3
 */

public class CPSAT_Question3_Test {

    static WebDriver webDriver;
    Question3_HomePage homePage;
    Question3_LiveMarketPage liveMarketPage;

    @BeforeClass
    public void preSetup() throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(CPSAT_UtilityFunctions.getPropertyValue("question_3_url"));
        homePage = new Question3_HomePage(webDriver);
        liveMarketPage = new Question3_LiveMarketPage(webDriver);
        CPSAT_UtilityFunctions.waitForParticularTime(5L);

    }
    @Test
    public void cpsatQuestion3Test() throws IOException, InterruptedException {
        String companyName = "Eicher Motors Limited";
        String fieldValue="Face Value";
        String highWeekValue="52 week high";
        String lowWeekValue="52 week low";
        homePage.enterTheCompanyName(Question3_XPath.seachField, companyName);
        CPSAT_UtilityFunctions.takeScreenShot(webDriver, "src/test/output/screenshots/Question3_Screenshots",
                companyName);
        liveMarketPage.fetchAndPrintTheValuesOnTheConsole(fieldValue,Question3_XPath.tableData);
        liveMarketPage.fetchAndPrintTheValuesOnTheConsole(highWeekValue,Question3_XPath.tableData);
        liveMarketPage.fetchAndPrintTheValuesOnTheConsole(lowWeekValue,Question3_XPath.tableData);

    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

}
