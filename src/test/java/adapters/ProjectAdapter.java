package adapters;

import modals.Project;
import modals.ResponseProject;
import modals.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {

    public ResponseStatus create(Project project, int status) {
        String response = post(gsonReader.toJson(project), status, baseUrlProjectCreate);
        return gsonReader.fromJson(response, ResponseStatus.class);
    }

    public ResponseProject getProject(String code) {
        String response = get(200, baseUrlProject + code);
        return gsonReader.fromJson(response, ResponseProject.class);
    }

    public ResponseProject deleteProject(String code) {
        String response = delete(200, baseUrlProject + code);
        return gsonReader.fromJson(response, ResponseProject.class);
    }
}
