import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.Map;


public class Comandos{
    protected AppiumDriver driver;

    public void fluentWait(WebElement element){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAValue(By element, String text){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBe(element, text));
    }

    public void clickElem(WebElement element){
        fluentWait(element);
        element.click();

    }

    public void swipeLeft(RemoteWebElement element){
        driver.executeScript("gesture: swipe", Map.of("elementId", element.getId(), "percentage", 50, "direction", "left"));

    }

    public void swipeUp(RemoteWebElement element) {
        driver.executeScript("gesture: swipe", Map.of("elementId", element.getId(),
                "percentage", 100,
                "direction", "up"));
    }




}

