package Tests;

import Base.Enum;
import adapters.ProjectAdapter;
import modals.Project;
import modals.ResponseProject;
import modals.ResponseStatus;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.w3c.dom.ranges.Range;

import static Base.RandomString.*;
import static org.testng.Assert.*;

public class ApiProjectCreateTest {

    @Test
    public void createProjectWithOnlyRequiredFields() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void createProjectWithRequiredFieldsAndDescription() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .description(randomString(10))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void createProjectWithRequiredFieldsAndDescriptionAndAccessAll() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .description(randomString(10))
                .access(Enum.accessAll.getValue())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Ignore
    @Test
    public void createShouldAcceptWithRequiredFieldsAndDescriptionAndAccessGroupAndGroupHash() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .description(randomString(10))
                .access(Enum.accessGroup.getValue())
                .group("team hash")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void createProjectWithRequiredFieldsAndDescriptionAndAccessNone() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .description(randomString(10))
                .access(Enum.accessNone.getValue())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void createProjectWithRequiredFieldsAndAccessAll() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .access(Enum.accessAll.getValue())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Ignore
    @Test
    public void createShouldAcceptProjectWithRequiredFieldsAndAccessGroup() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(5))
                .access(Enum.accessGroup.getValue())
                .group("team hash")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void createProjectWithRequiredFieldsAndAccessNone() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(4))
                .access(Enum.accessNone.getValue())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseProject actualGet = new ProjectAdapter().getProject(project.getCode());
        assertTrue(actualGet.isStatus());
        assertEquals(actualGet.getResult().getTitle(), project.getTitle());
        assertEquals(actualGet.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void fieldTitleShouldBeRequired() {
        Project project = Project.builder()
                .code(randomString(5))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldTitle.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldTitleMessage.getValue());
    }

    @Test
    public void fieldCodeShouldBeRequired() {
        Project project = Project.builder()
                .title(randomString(5))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageRequired.getValue());

    }

    @Test
    public void fieldCodeShouldBeUnique() {
        String code = randomString(5);
        Project project = Project.builder()
                .title(randomString(5))
                .code(code)
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        ResponseStatus actualNext = new ProjectAdapter().create(project, 200);
        assertFalse(actualNext.isStatus());
        assertEquals(actualNext.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actualNext.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actualNext.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageSameCode.getValue());
        DeleteProject(project.getCode());
    }

    @Test
    public void fieldCodeShouldNotAcceptSpecialSymbols() {
        Project project = Project.builder()
                .title(randomString(5))
                .code(randomStringSymbols(5))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageOnlyLatin.getValue());
    }

    @Test
    public void fieldCodeShouldNotAcceptDigits() {
        Project project = Project.builder()
                .title(randomString(12))
                .code(randomDigits(5))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageOnlyLatin.getValue());
    }

    @Test
    public void fieldCodeShouldNotAcceptCyrillicSymbols() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomStringCyrillic(5))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageOnlyLatin.getValue());
    }

    @Test
    public void fieldCodeShouldNotAcceptOneSymbol() {
        Project project = Project.builder()
                .title(randomString(5))
                .code(randomString(1))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageCodeLength.getValue());
    }

    @Test
    public void fieldCodeShouldAcceptTwoSymbols() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(2))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void fieldCodeShouldAcceptSixSymbols() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertTrue(actual.isStatus());
        assertEquals(actual.getResult().getCode(), project.getCode());
        DeleteProject(project.getCode());
    }

    @Test
    public void fieldCodeShouldNotAcceptSevenSymbols() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(7))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.errorFieldCode.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldCodeMessageCodeLength.getValue());
    }

    @Ignore
    @Test
    public void fieldAccessShouldNotAcceptImpossibleValue() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .access("asd")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), "Invalid payload.");
    }

    @Test
    public void createShouldBeFailedWithoutGroupHashWhenAccessGroup() {
        Project project = Project.builder()
                .title(randomString(10))
                .code(randomString(6))
                .access(Enum.accessGroup.getValue())
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertFalse(actual.isStatus());
        assertEquals(actual.getErrorMessage(), Enum.errorMessageDataIsInvalid.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getField(), Enum.accessGroup.getValue());
        assertEquals(actual.getErrorFields().get(Range.START_TO_START).getError(), Enum.errorFieldGroupMessageRequired.getValue());
    }

    public void DeleteProject(String name) {
        ResponseProject delete = new ProjectAdapter().deleteProject(name);
        assertTrue(delete.isStatus());
    }
}
