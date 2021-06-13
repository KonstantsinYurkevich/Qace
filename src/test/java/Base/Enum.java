package Base;

public enum Enum {
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
