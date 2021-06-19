package adapters;

import com.google.gson.Gson;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String token = System.getenv().getOrDefault("API_TOKEN", PropertyReader.getProperty("api.token"));
    String tokenValue = System.getenv().getOrDefault("API_TOKEN_VALUE", PropertyReader.getProperty("api.token.value"));
    String contentType = System.getenv().getOrDefault("API_CONTENT_TYPE", PropertyReader.getProperty("api.content.type"));
    String contentTypeValue = System.getenv().getOrDefault("API_CONTENT_TYPE_VALUE", PropertyReader.getProperty
            ("api.content.type.value"));
    String baseUrlProjectCreate = System.getenv().getOrDefault("API_BASE_URL_PROJECT_CREATE", PropertyReader.
            getProperty("api.base.url.project.create"));
    String baseUrlProject = System.getenv().getOrDefault("API_BASE_URL_PROJECT", PropertyReader.
            getProperty("api.base.url.project"));
    String baseUrlProjectSuiteCreate = System.getenv().getOrDefault("API_BASE_URL_PROJECT_SUITE_CREATE", PropertyReader.
            getProperty("api.base.url.project.suite.create"));

    Gson gsonReader = new Gson();

    public String post(String body, int status, String url) {
        return
                given().
                        header(token, tokenValue).
                        header(contentType, contentTypeValue).
                        body(body).
                        log().all().
                        when().
                        post(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    public String get(int status, String url) {
        return
                given().
                        header(token, tokenValue).
                        header(contentType, contentTypeValue).
                        log().all().
                        when().
                        get(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }

    public String delete(int status, String url) {
        return
                given().
                        header(token, tokenValue).
                        header(contentType, contentTypeValue).
                        log().all().
                        when().
                        delete(url).
                        then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
