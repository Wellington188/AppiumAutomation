import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class NativeViewPage extends Comandos {
    public NativeViewPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Native View Demo\"]")
    public WebElement pageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View one \"]")
    public WebElement viewOne;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View two \"]")
    public WebElement viewTwo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View three \"]")
    public WebElement viewThree;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;

}
