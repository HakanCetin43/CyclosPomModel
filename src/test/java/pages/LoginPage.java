package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

    static WebElement element = null;

    public static WebDriver navigate(WebDriver driver, String url) {
        driver.navigate().to(url);
        return driver;
    }

    public static void navigateSpare(WebDriver driver, String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public static void enterUsername(WebDriverWait wait, String input) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("principal")));
        element.sendKeys(input);
    }

    public static void enterPassword(WebDriverWait wait, String username) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        element.sendKeys(username);
    }

    public static void click(WebDriverWait wait) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='actionButton']")));
        element.click();
    }

    public static void viewsErrorMessage(WebDriverWait wait, String expectedErrorMessage) {

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//*[contains(@class, 'notificationText notificationText')]")));
        String actualMessage = element.getText();

        Assert.assertTrue(actualMessage.contains(expectedErrorMessage));
    }
}