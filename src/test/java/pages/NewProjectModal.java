package pages;

import Base.Enum;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class NewProjectModal extends BasePage {


    @Override
    public boolean IsPageOpened() {
        return $$(Enum.newProjectPageNameLocator.getValue()).findBy(value(Enum.textNewProject.getValue())).exists();
    }

    @Step("Creating new project according data")
    public NewProjectPage createProject(Project project) {
        log.info("Fill in form of new project according data");
        $(Enum.inputTitleLocator.getValue()).sendKeys(project.getProjectName());
        $(Enum.inputCodeLocator.getValue()).sendKeys(project.getProjectCode());
        $(Enum.inputDescriptionLocator.getValue()).sendKeys(project.getDescription());
        save();
        return new NewProjectPage();
    }

    @Step("click button save")
    public void save() {
        $(Enum.buttonUpdateAndCreateProjectLocator.getValue()).click();
    }
}
