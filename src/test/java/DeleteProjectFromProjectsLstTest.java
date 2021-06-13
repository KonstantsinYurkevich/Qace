import modals.Project;
import modals.ProjectFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DeleteProjectFromProjectsLstTest extends BaseTest {
    @Test
    public void projectShouldBeDeleted() {
        boolean isPageOpened = logInPage
                .openPage()
                .IsPageOpened();
        assertTrue(isPageOpened);
        logInPage
                .logIn();
        Project project = ProjectFactory.get();
        isPageOpened = projectsPage
                .openPage()
                .IsPageOpened();
        assertTrue(isPageOpened);
        projectsPage
                .clockNewButton()
                .createProject(project);
        isPageOpened = newProjectPage
                .IsPageOpened();
        assertTrue(isPageOpened);
        isPageOpened = projectsPage
                .openPage()
                .isProjectExists(project.getProjectName());
        assertTrue(isPageOpened);
        projectsPage
                .deleteProject(project.getProjectName());
        boolean isProjectExists = projectsPage
                .isProjectExists(project.getProjectName());
        assertFalse(isProjectExists);
    }
}
