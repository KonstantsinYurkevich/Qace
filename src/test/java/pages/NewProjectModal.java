package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import modals.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectModal extends BasePage {

    public NewProjectModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public SelenideElement IsPageOpened() {
        return $(By.xpath("//h1[contains(text(),'New Project')]")).shouldBe(Condition.visible);
    }

    public NewProjectPage createProject(Project project) {
        $("input#inputTitle").sendKeys(project.getProjectName());
        $("input#inputCode").sendKeys(project.getProjectCode());
        $("textArea#inputDescription").sendKeys(project.getDescription());
        save();
        return new NewProjectPage(driver);
    }

    public void save() {
        $(By.xpath("//button[contains(@class,'btn-primary')]")).click();
    }
}
