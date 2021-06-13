package modals;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String alphaNumericString = fakeValuesService.regexify("[a-z]{5}");
        return Project.builder()
                .projectName(faker.funnyName().name())
                .projectCode(alphaNumericString)
                .description(faker.harryPotter().spell())
                .build();
    }
}
