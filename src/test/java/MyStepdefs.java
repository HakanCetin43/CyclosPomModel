import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static pages.LoginPage.*;

public class MyStepdefs {

    static WebDriver driver;
    static WebDriverWait wait;

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver","D:/Drivers/chromedriver .exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void quit() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }
    @Given("the user navigates to {string}")
    public void theUserNavigatesTo(String url) {
        navigate(driver, url);
    }
    @When("user enters username {string}")
    public void userEntersUsername(String arg0) {
        enterUsername(wait, arg0);
    }

    @And("user enters password  {string}")
    public void userEntersPassword(String arg0) {
        enterPassword(wait, arg0);
    }


    @And("user clicks sign in button")
    public void theUserClicks() {
        click(wait);
    }

    @Then("user views errorMessage {string}")
    public void theUserViewsErrorMessage(String expectedErrorMessage) {
        viewsErrorMessage(wait, expectedErrorMessage);
    }


}
