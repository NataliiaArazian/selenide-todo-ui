package todo;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    @BeforeTest
    public void setup() {
        open(Config.basicUrl);
    }

    @AfterTest
    public void close() {
        Selenide.closeWebDriver();
    }
}
