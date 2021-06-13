package pages;

import Base.Enum;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage extends BasePage {

    @Override
    public boolean IsPageOpened() {
        return $(Enum.projectAvatarLocator.getValue()).isDisplayed();
    }

    public boolean editName(String newProjectName) {
        openSettings();
        $(Enum.inputTitleLocator.getValue()).clear();
        $(Enum.inputTitleLocator.getValue()).sendKeys(newProjectName);
        submit();
        return Objects.requireNonNull($(Enum.inputTitleLocator.getValue()).getAttribute(Enum.attributeValue.getValue()))
                .contains(newProjectName);

    }

    public boolean editCode(String newCode) {
        openSettings();
        $(Enum.inputCodeLocator.getValue()).clear();
        $(Enum.inputCodeLocator.getValue()).sendKeys(newCode);
        submit();
        return Objects.requireNonNull($(Enum.inputCodeLocator.getValue()).getAttribute(Enum.attributeValue.getValue()))
                .contains(newCode);

    }

    public boolean editDescription(String newDescription) {
        openSettings();
        $(Enum.inputDescriptionLocator.getValue()).clear();
        $(Enum.inputDescriptionLocator.getValue()).sendKeys(newDescription);
        submit();

        return $(Enum.inputDescriptionLocator.getValue()).shouldHave(exactText(newDescription)).isDisplayed();

    }

    public boolean editAccessType(String newAccessType) {
        openSettings();
        $$(Enum.accessTypeLocator.getValue()).findBy(value(newAccessType)).click();
        submit();
        return $$(Enum.accessTypeLocator.getValue()).findBy(value(newAccessType)).shouldHave(attribute(Enum.attributeChecked.getValue())).isDisplayed();

    }

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

    public void deleteProject() {
        openSettings();
        $(Enum.buttonDeleteProjectLocator.getValue()).click();
        submit();
    }

    public void openSettings() {
        $(Enum.settingsLocator.getValue()).click();
        $$(Enum.projectSettingsPageLocator.getValue()).findBy(text(Enum.textSettings.getValue())).shouldBe(visible);
    }


    public void submit() {
        $(Enum.buttonUpdateAndCreateProjectLocator.getValue()).click();
    }
}
