package modals;

import Base.RandomString;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class ProjectFactory extends RandomString {
    @Step("Get random params of project")
    public static Project get() {
        Faker faker = new Faker();
        return Project.builder()
                .title(faker.funnyName().name())
                .code(randomString(5))
                .description(faker.harryPotter().spell())
                .build();
    }

}
