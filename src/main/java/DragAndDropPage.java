import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class DragAndDropPage extends Comandos {

    public DragAndDropPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "dragMe")
    public RemoteWebElement dragObject;

    @AndroidFindBy(accessibility = "dropzone")
    public RemoteWebElement dropZone;

    @AndroidFindBy(accessibility = "success")
    public WebElement successMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;

    public void dragGesture(){
        fluentWait(dropZone);
        driver.executeScript("gesture: dragAndDrop", Map.of("sourceId", dragObject.getId(), "destinationId", dropZone.getId()));

    }
}
