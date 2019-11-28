import CPSAT_PageObject.Question3.PageObject.Locators.Question3_XPath;
import CPSAT_PageObject.Question4.PageObject.Locators.Question4_XPath;
import CPSAT_PageObject.Question4.PageObject.Pages.Question4_HomePage;
import CPSAT_PageObject.Question4.PageObject.Pages.Question4_LiveMarketPage;
import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

/**
 * This class contains all the test methods of Question 4
 */
public class CPSAT_Question4_Test {
    static WebDriver webDriver;
    Question4_HomePage homePage;
    Question4_LiveMarketPage liveMarketPage;

    @BeforeClass
    public void preSetup() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.manage().window().maximize();
        webDriver.get(CPSAT_UtilityFunctions.getPropertyValue("question_4_url"));
        homePage = new Question4_HomePage(webDriver);
        liveMarketPage = new Question4_LiveMarketPage(webDriver);
        CPSAT_UtilityFunctions.waitForParticularTime(5L);

    }

    @DataProvider(name = "Company Names")
    public Iterator<Object[]> getCompanyNames() throws IOException {

        return CPSAT_UtilityFunctions.readExcelData("src/test/resources/ExcelSheets/CompanyList.xlsx").iterator();
    }

    @Test(dataProvider = "Company Names")
    public void cpsatQuestion4Test(String companyName) throws IOException, InterruptedException {
        String fieldValue="Face Value";
        String highWeekValue="52 week high";
        String lowWeekValue="52 week low";
        homePage.enterTheCompanyName(Question3_XPath.seachField, companyName);
        CPSAT_UtilityFunctions.takeScreenShot(webDriver, "src/test/output/screenshots/Question4_Screenshots", companyName);
        liveMarketPage.fetchAndPrintTheValuesOnTheConsole(fieldValue,Question4_XPath.tableData);
        liveMarketPage.fetchAndPrintTheValuesOnTheConsole(highWeekValue,Question4_XPath.tableData);
        liveMarketPage.fetchAndPrintTheValuesOnTheConsole(lowWeekValue,Question4_XPath.tableData);


    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }

}


