package Tests;

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
                .isProjectExists(project.getTitle());
        projectsPage
                .openProject(project.getTitle());
        Project infoForChangeAll = ProjectFactory.get();
        Project infoForChangeSeparate = ProjectFactory.get();
        boolean apply = projectPage
                .editName(infoForChangeSeparate.getTitle());
        assertTrue(apply);
        apply = projectPage
                .editCode(infoForChangeSeparate.getCode());
        assertTrue(apply);
        apply = projectPage
                .editDescription(infoForChangeSeparate.getDescription());
        assertTrue(apply);
        apply = projectPage
                .editAccessType(accessTypePublic);
        assertTrue(apply);
        apply = projectPage
                .editAllInfo(infoForChangeAll.getTitle(), infoForChangeAll.getCode(), infoForChangeAll.getDescription(),
                        accessTypePrivate);
        assertTrue(apply);
    }
}
