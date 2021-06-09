package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewProjectModal extends BasePage {

    public NewProjectModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return $(By.xpath("//h1[contains(text(),'New Project')]")).isDisplayed();
    }

    @Step("Creating new project according data")
    public NewProjectPage createProject(Project project) {
        log.info("Fill in form of new project according data");
        $("input#inputTitle").sendKeys(project.getProjectName());
        $("input#inputCode").sendKeys(project.getProjectCode());
        $("textArea#inputDescription").sendKeys(project.getDescription());
        save();
        return new NewProjectPage(driver);
    }

    @Step("click button save")
    public void save() {
        $(By.xpath("//button[contains(@class,'btn-primary')]")).click();
    }
}
