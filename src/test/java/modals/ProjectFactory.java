package modals;

import com.github.javafaker.Faker;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        return Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(faker.pokemon().name())
                .description(faker.harryPotter().spell())
                .build();
    }
}
