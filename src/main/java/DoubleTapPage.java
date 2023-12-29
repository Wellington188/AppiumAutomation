import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class DoubleTapPage extends Comandos{

    public DoubleTapPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "doubleTapMe")
    public RemoteWebElement doubleTapMe;

    @AndroidFindBy(id = "android:id/message")
    public WebElement message;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement okButton;

    public void doubleTapGesture(){
        driver.executeScript("gesture: doubleTap", Map.of("elementId", doubleTapMe.getId()));

    }
}
