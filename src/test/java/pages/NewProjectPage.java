package pages;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage {

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsPageOpened() {
        return $("div.d-flex > p").isDisplayed();
    }
}
