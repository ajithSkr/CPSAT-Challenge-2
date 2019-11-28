import CPSAT_PageObject.Question5.PageObject.Locators.Question5_XPath;
import CPSAT_PageObject.Question5.PageObject.Pages.Question5_HomePage;
import CPSAT_PageObject.Question5.PageObject.Pages.Question5_StoreFinderPage;
import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * This class contains all the test methods of Question 5
 */
public class CPSAT_Question5_Test {
    static WebDriver webDriver;
    Question5_HomePage homePage;
    Question5_StoreFinderPage storeFinderPage;

    @BeforeClass
    public void preSetup() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get(CPSAT_UtilityFunctions.getPropertyValue("question_5_url"));
        homePage = new Question5_HomePage(webDriver);
        storeFinderPage = new Question5_StoreFinderPage(webDriver);
        CPSAT_UtilityFunctions.waitForParticularTime(5L);
        CPSAT_UtilityFunctions.implicityWait(webDriver, 30L);

    }

    @Test
    public void cpsatQuestion5Test() throws InterruptedException, IOException {
        homePage.clickOnTheBannerSliderForTheNumberOFTimesTillTheBannerGetsRepeated(Question5_XPath.allBannerSlides,Question5_XPath.nextButton,
                Question5_XPath.currentSlide);
//        homePage.printAllTheAccessoriesUnderMenSectionMenFragnance(Question5_XPath.menTab,
//                Question5_XPath.mensFrangnance, Question5_XPath.mensFragnanceElements);
//        homePage.clickOnAllStoresLink(Question5_XPath.allStoresLink);
//        List<WebElement> allStoresOptions =
//                storeFinderPage.printTheCitiesNameThatAvailableInFindStoresInYourCity(Question5_XPath.selectCityField
//                        , Question5_XPath.allCitiesOptions);
//        storeFinderPage.assertTheAgraBhopalMysoreAreAvailableInFindStoresInYourCity(allStoresOptions);
//        storeFinderPage.printThePageTitleInConsole();
    }


    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }


}
