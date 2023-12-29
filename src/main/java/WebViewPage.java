import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebViewPage extends Comandos{

    public WebViewPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Hacker News\"]")
    public WebElement webTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Hacker News\"]")
    public WebElement webLoginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;
}
