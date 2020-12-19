package todo;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    @BeforeMethod
    public void setup() {
        open(Config.basicUrl);
    }

    @AfterMethod
    public void close() {
        Selenide.closeWebDriver();
    }
}
