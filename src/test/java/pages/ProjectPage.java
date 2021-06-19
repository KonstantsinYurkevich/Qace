package pages;

import Base.Enum;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage extends BasePage {

    @Override
    public boolean IsPageOpened() {
        return $(Enum.projectAvatarLocator.getValue()).isDisplayed();
    }

    @Step("Edit project title")
    public boolean editName(String newProjectName) {
        openSettings();
        $(Enum.inputTitleLocator.getValue()).clear();
        $(Enum.inputTitleLocator.getValue()).sendKeys(newProjectName);
        submit();
        return Objects.requireNonNull($(Enum.inputTitleLocator.getValue()).getAttribute(Enum.attributeValue.getValue()))
                .contains(newProjectName);

    }

    @Step("Edit project code")
    public boolean editCode(String newCode) {
        openSettings();
        $(Enum.inputCodeLocator.getValue()).clear();
        $(Enum.inputCodeLocator.getValue()).sendKeys(newCode);
        submit();
        return Objects.requireNonNull($(Enum.inputCodeLocator.getValue()).getAttribute(Enum.attributeValue.getValue()))
                .contains(newCode);

    }

    @Step("Edit project description")
    public boolean editDescription(String newDescription) {
        openSettings();
        $(Enum.inputDescriptionLocator.getValue()).clear();
        $(Enum.inputDescriptionLocator.getValue()).sendKeys(newDescription);
        submit();

        return $(Enum.inputDescriptionLocator.getValue()).shouldHave(exactText(newDescription)).isDisplayed();

    }

    @Step("Edit project access type")
    public boolean editAccessType(String newAccessType) {
        openSettings();
        $$(Enum.accessTypeLocator.getValue()).findBy(value(newAccessType)).click();
        submit();
        return $$(Enum.accessTypeLocator.getValue()).findBy(value(newAccessType)).shouldHave(attribute(Enum.attributeChecked.getValue())).isDisplayed();

    }

    @Step("Edit project title, code, description, access type")
    public boolean editAllInfo(String newName, String newCode, String newDescription, String newAccessType) {
        openSettings();
        $(Enum.inputTitleLocator.getValue()).clear();
        $(Enum.inputTitleLocator.getValue()).sendKeys(newName);
        $(Enum.inputCodeLocator.getValue()).clear();
        $(Enum.inputCodeLocator.getValue()).sendKeys(newCode);
        $(Enum.inputDescriptionLocator.getValue()).clear();
        $(Enum.inputDescriptionLocator.getValue()).sendKeys(newDescription);
        $$(Enum.accessTypeLocator.getValue()).findBy(value(newAccessType)).click();
        submit();
        return true;

    }

    @Step("Click button delete project")
    public void deleteProject() {
        openSettings();
        $(Enum.buttonDeleteProjectLocator.getValue()).click();
        submit();
    }

    @Step("Open project setting")
    public void openSettings() {
        $(Enum.settingsLocator.getValue()).click();
        $$(Enum.projectSettingsPageLocator.getValue()).findBy(text(Enum.textSettings.getValue())).shouldBe(visible);
    }


    @Step("Submit")
    public void submit() {
        $(Enum.buttonUpdateAndCreateProjectLocator.getValue()).click();
    }
}
