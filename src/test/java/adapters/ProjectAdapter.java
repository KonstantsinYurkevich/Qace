package adapters;

import io.qameta.allure.Step;
import modals.Project;
import modals.ResponseProject;
import modals.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {

    @Step("Getting answer from API after create project request")
    public ResponseStatus create(Project project, int status) {
        String response = post(gsonReader.toJson(project), status, baseUrlProjectCreate);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    @Step("Getting answer from API after get project request")
    public ResponseProject getProject(String code) {
        String response = get(200, baseUrlProject + code);
        return gsonReader.fromJson(response, ResponseProject.class);
    }

    @Step("Getting answer from API after delete project request")
    public ResponseProject deleteProject(String code) {
        String response = delete(200, baseUrlProject + code);
        return gsonReader.fromJson(response, ResponseProject.class);
    }
}
