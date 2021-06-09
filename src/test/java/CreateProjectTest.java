import modals.Project;
import modals.ProjectFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateProjectTest extends BaseTest {
    @Test(description = "Creating project and fin it in list")
    public void projectShouldBeCreated() {
        boolean isPageOpened = logInPage
                .openPage()
                .IsPageOpened();
        assertTrue(isPageOpened, "LogIn page doesn't open");
        logInPage
                .logIn();
        isPageOpened = projectsPage
                .openPage()
                .IsPageOpened();
        assertTrue(isPageOpened, "Projects page doesn't open");
        Project project = ProjectFactory.get();
        projectsPage
                .clockNewButton()
                .createProject(project);
        isPageOpened = newProjectPage
                .IsPageOpened();
        assertTrue(isPageOpened, "New Project page doesn't open");
        isPageOpened = projectsPage
                .openPage()
                .isProjectExists(project.getProjectName());
        assertTrue(isPageOpened, "New project doesn't exist");

    }

}
