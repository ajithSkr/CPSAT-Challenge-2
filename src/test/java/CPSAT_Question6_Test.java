import CPSAT_PageObject.Question6.PageObject.Locators.Question6_XPath;
import CPSAT_PageObject.Question6.PageObject.Pages.Question6_HomePage;
import CPSAT_PageObject.Question6.PageObject.Pages.Question6_LiveMarketPage;
import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * This class contains all the test methods for Question 6
 */
public class CPSAT_Question6_Test {

    static WebDriver webDriver;
    Question6_HomePage homePage;
    Question6_LiveMarketPage liveMarketPage;

    @BeforeClass
    public void preSetup() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get(CPSAT_UtilityFunctions.getPropertyValue("question_6_url"));
        homePage = new Question6_HomePage(webDriver);
        liveMarketPage = new Question6_LiveMarketPage(webDriver);
        CPSAT_UtilityFunctions.waitForParticularTime(5L);
        CPSAT_UtilityFunctions.implicityWait(webDriver, 30L);

    }

    @Test
    public void cpsatQuestion6Test() throws IOException, ParseException {
        homePage.hoverOnTheLiveMarketTab(Question6_XPath.liveMarketTab);
        homePage.clickOnTopTenGainersLosersOption(Question6_XPath.topTenGainersLosersTab);
        liveMarketPage.storeTheTopGainersValueInExcelSheet(Question6_XPath.gainersTab,
                Question6_XPath.gainersTableHeader, Question6_XPath.gainersTableData);
        liveMarketPage.storeTheTopLosersValueInExcelSheet(Question6_XPath.losersTab,
                Question6_XPath.losersTableHeader, Question6_XPath.losersTableData);
        liveMarketPage.assertTopGainersAndLosersPercentage("src/test/resources/ExcelSheets/TopGainers&LosersData.xlsx");
        liveMarketPage.extractDateAndTimeAndCompareWithTheSystemResult(Question6_XPath.refreshGif,
                Question6_XPath.dateAndTime);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
