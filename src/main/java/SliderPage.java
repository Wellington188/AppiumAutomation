import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.support.PageFactory;

import javax.security.auth.callback.TextOutputCallback;
import java.io.SequenceInputStream;
import java.time.Duration;
import java.util.Map;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

public class SliderPage extends Comandos{


    public SliderPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "slider")
    public RemoteWebElement slider;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;

    public void moveSlider(){
        fluentWait(slider);
        driver.executeScript("gesture: swipe", Map.of("elementId", slider.getId(), "percentage", 50, "direction", "right"));

    }
}
