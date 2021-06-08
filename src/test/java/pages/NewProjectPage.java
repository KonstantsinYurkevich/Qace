package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage{

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SelenideElement IsPageOpened() {
        return $("div.d-flex > p").should(Condition.exist);
    }
}
