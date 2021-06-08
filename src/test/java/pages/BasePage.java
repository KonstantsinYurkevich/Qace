package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

@Log4j2
public abstract class BasePage {
    WebDriver driver;
    String user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
    String password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract SelenideElement IsPageOpened();

}
