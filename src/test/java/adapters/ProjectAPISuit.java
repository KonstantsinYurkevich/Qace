package adapters;


public class ProjectAPISuit extends BaseAdapter {

    public String create(String body, int status, String code) {
        return post(body, status, baseUrlProjectSuiteCreate + code);
    }
}
