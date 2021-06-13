package pages;

import Base.Enum;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HomePage extends BasePage {

    @Override
    public boolean IsPageOpened() {
        return $(Enum.createNewProjectButtonLocator.getValue()).isDisplayed();
    }


}
