import modals.Project;
import modals.ProjectFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EditProjectTest extends BaseTest {
    String accessTypePublic = "public";
    String accessTypePrivate = "private";

    @Test
    public void ProjectNameShouldBeChanged() {
        logInPage
                .openPage()
                .logIn();
        Project project = ProjectFactory.get();
        projectsPage
                .clockNewButton()
                .createProject(project);
        projectsPage
                .openPage()
                .isProjectExists(project.getProjectName());
        projectsPage
                .openProject(project.getProjectName());
        Project infoForChangeAll = ProjectFactory.get();
        Project infoForChangeSeparate = ProjectFactory.get();
        boolean apply = projectPage
                .editName(infoForChangeSeparate.getProjectName());
        assertTrue(apply);
        apply = projectPage
                .editCode(infoForChangeSeparate.getProjectCode());
        assertTrue(apply);
        apply = projectPage
                .editDescription(infoForChangeSeparate.getDescription());
        assertTrue(apply);
        apply = projectPage
                .editAccessType(accessTypePublic);
        assertTrue(apply);
        apply = projectPage
                .editAllInfo(infoForChangeAll.getProjectName(), infoForChangeAll.getProjectCode(), infoForChangeAll.getDescription(),
                        accessTypePrivate);
        assertTrue(apply);
    }
}
