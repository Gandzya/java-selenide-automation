package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;



@ExtendWith(CustomTestWatcher.class)
public class BaseGuiTest {

    public SoftAssertions softly;

    @BeforeEach
    public void newAssert() {
        softly = new SoftAssertions();
    }

    @AfterEach
    public void softAssert() {
        softly.assertAll();
    }

    @BeforeAll
    public static void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");

        Configuration.browserCapabilities = options;
        Selenide.open();

    }

    @AfterAll
    public static void close(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();

    }

}
