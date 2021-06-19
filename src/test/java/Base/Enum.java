package Base;

public enum Enum {
    accessAll("all"),
    accessGroup("group"),
    accessNone("none"),
    errorMessageDataIsInvalid("Data is invalid"),
    errorFieldTitle("title"),
    errorFieldCode("code"),
    errorFieldCodeMessageRequired("Project code is required"),
    errorFieldCodeMessageSameCode("Project with the same code already exists."),
    errorFieldCodeMessageOnlyLatin("Project code can contain only latin alphabet symbols."),
    errorFieldCodeMessageCodeLength("Project code length should be from 2 to 6 symbols."),
    errorFieldGroupMessageRequired("Group hash field is required for group access."),
    errorFieldTitleMessage("Title is required"),
    textSettings("Settings"),
    attributeValue("value"),
    attributeChecked("checked"),
    pageProjects("/projects"),
    pageLogIn("/login"),
    logInButtonLocator("#btnLogin"),
    inputEmailLocator("#inputEmail"),
    inputPasswordLocator("#inputPassword"),
    userMenuLocator("#user-menu"),
    signOutLocator("a[href=\"https://app.qase.io/logout\"]"),
    buttonUpdateAndCreateProjectLocator("[type = 'submit']"),
    inputTitleLocator("input#inputTitle"),
    inputCodeLocator("input#inputCode"),
    inputDescriptionLocator("textArea#inputDescription"),
    textNewProject("New Project"),
    newProjectPageNameLocator("h1"),
    inProjectNameOfProjectLocator("div.d-flex > p"),
    settingsLocator("[title=Settings]"),
    accessTypeLocator("div > input"),
    projectSettingsPageLocator(".col-lg-12 > h1"),
    buttonDeleteProjectLocator(".btn-cancel"),
    projectAvatarLocator(".avatar-xxs"),
    createNewProjectButtonLocator("#createButton"),
    projectsListProjectDropDownLocator(".btn-dropdown"),
    searchLocator(".filters-block-items >div >input"),
    ProjectsListProjectDropDownButtonDeleteLocator(".text-danger"),
    searchResultLocator(".defect-title"),
    projectPageOpenProjectLocator("//a[contains(text(),'%s')]");

    public final String value;

    Enum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
