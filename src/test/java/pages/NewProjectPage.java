package pages;

import Base.Enum;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage {

    @Override
    public boolean IsPageOpened() {
        return $(Enum.inProjectNameOfProjectLocator.getValue()).isDisplayed();
    }
}
