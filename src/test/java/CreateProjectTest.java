import modals.Project;
import modals.ProjectFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateProjectTest extends BaseTest {
    @Test
    public void projectShouldBeCreated() {

        logInPage
                .openPage()
                .IsPageOpened();
        logInPage
                .logIn();
        projectsPage
                .openPage()
                .IsPageOpened();

        Project project = ProjectFactory.get();
        projectsPage
                .clockNewButton()
                .createProject(project);
        newProjectPage
                .IsPageOpened();
        boolean isExists = projectsPage
                .openPage()
                .isProjectExists(project.getProjectName());
        assertTrue(isExists, "New project exists");


    }
}
