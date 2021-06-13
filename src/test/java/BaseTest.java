import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public abstract class BaseTest {
    protected LogInPage logInPage;
    protected HomePage homePage;
    protected ProjectsPage projectsPage;
    protected NewProjectPage newProjectPage;
    protected ProjectPage projectPage;
    String user, password;


    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        logInPage = new LogInPage();
        homePage = new HomePage();
        projectsPage = new ProjectsPage();
        newProjectPage = new NewProjectPage();
        projectPage = new ProjectPage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }


}
