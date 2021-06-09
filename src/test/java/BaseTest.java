import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LogInPage;
import pages.NewProjectPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BaseTest {
    protected LogInPage logInPage;
    protected HomePage homePage;
    protected ProjectsPage projectsPage;
    protected NewProjectPage newProjectPage;
    WebDriver driver;
    String user, password;


    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        logInPage = new LogInPage(driver);
        homePage = new HomePage(driver);
        projectsPage = new ProjectsPage(driver);
        newProjectPage = new NewProjectPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }


}
