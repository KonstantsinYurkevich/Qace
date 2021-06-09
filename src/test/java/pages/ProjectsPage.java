package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return $("#createButton").isDisplayed();
    }

    @Step("Opening projects page ")
    public ProjectsPage openPage() {
        log.info("Opening projects page");
        open("/projects");
        return new ProjectsPage(driver);
    }

    @Step("click new button on Projects page")
    public NewProjectModal clockNewButton() {
        log.info("Click new button on projects page");
        $("#createButton").click();
        return new NewProjectModal(driver);
    }

    public boolean isProjectExists(String projectName) {
        log.info("validating name of new project in projects list");
        $(".filters-block-items >div >input").sendKeys(projectName);
        try {
            $$(".defect-title").should(itemWithText(projectName));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
