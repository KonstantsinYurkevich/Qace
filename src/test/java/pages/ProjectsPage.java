package pages;

import Base.Enum;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {


    @Override
    public boolean IsPageOpened() {
        return $(Enum.createNewProjectButtonLocator.getValue()).isDisplayed();
    }

    @Step("Open project")
    public ProjectPage openProject(String projectName) {
        log.info("Open project " + projectName);
        $(By.xpath(String.format(Enum.projectPageOpenProjectLocator.getValue(), projectName))).click();
        return new ProjectPage();
    }

    @Step("Opening projects page ")
    public ProjectsPage openPage() {
        log.info("Opening projects page");
        open(Enum.pageProjects.getValue());
        return new ProjectsPage();
    }

    @Step("click new button on Projects page")
    public NewProjectModal clockNewButton() {
        log.info("Click new button on projects page");
        $(Enum.createNewProjectButtonLocator.getValue()).click();
        return new NewProjectModal();
    }

    public boolean isProjectExists(String projectName) {
        log.info("validating name of new project in projects list");
        $(Enum.searchLocator.getValue()).clear();
        $(Enum.searchLocator.getValue()).sendKeys(projectName);
        try {
            $$(Enum.searchResultLocator.getValue()).should(itemWithText(projectName));
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public void deleteProject(String projectName) {
        $(Enum.searchLocator.getValue()).clear();
        $(Enum.searchLocator.getValue()).sendKeys(projectName);
        $(Enum.projectsListProjectDropDownLocator.getValue()).click();
        $(Enum.ProjectsListProjectDropDownButtonDeleteLocator.getValue()).click();
        submit();


    }

    public void submit() {
        $(Enum.buttonUpdateAndCreateProjectLocator.getValue()).click();
    }
}
