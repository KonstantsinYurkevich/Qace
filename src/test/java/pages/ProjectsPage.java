package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage{

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SelenideElement IsPageOpened() {
        return $("#createButton").should(Condition.exist);
    }

    public ProjectsPage openPage() {
        log.info("Opening LogIn page");
        open("/projects");
        return new ProjectsPage(driver);
    }
    public NewProjectModal clockNewButton() {
        log.info("Opening projects page");
        $("#createButton").click();
        return new NewProjectModal(driver);
    }
    public boolean isProjectExists(String projectName) {
        try {
            $$("tr >td >div >a.defect-title").should(itemWithText(projectName));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
