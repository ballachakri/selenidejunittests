package hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @BeforeAll
    public static void setUpConfig() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).includeSelenideSteps(true)
        );
    }

    @BeforeEach
    public void navigateToHomePage() {

        open("https://tutorialsninja.com/demo");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void takeScreenShot() {

        byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
        InputStream is = new ByteArrayInputStream(screenshot);
        Allure.attachment("image.png", is);
    }

    @AfterAll
    public static void tearDown(){

        WebDriverRunner.getWebDriver().quit();

    }

}
