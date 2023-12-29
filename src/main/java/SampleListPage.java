import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class SampleListPage extends Comandos{

    public SampleListPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"scrollView\"]/android.view.ViewGroup")
    public RemoteWebElement scroll;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Samples List\"]")
    public WebElement pageTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"chainedView\"]/android.view.ViewGroup")
    public WebElement nativeView;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"slider1\"]/android.view.ViewGroup")
    public WebElement slider;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"verticalSwipe\"]/android.view.ViewGroup")
    public WebElement verticalSwiping;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"dragAndDrop\"]/android.view.ViewGroup")
    public WebElement dragAndDrop;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"doubleTap\"]/android.view.ViewGroup")
    public WebElement doubleTap;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"longPress\"]/android.view.ViewGroup")
    public WebElement longPress;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"photoView\"]/android.view.ViewGroup")
    public WebElement photoView;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"webView\"]/android.view.ViewGroup")
    public WebElement webView;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"carousel\"]/android.view.ViewGroup")
    public WebElement carousel;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"wheelPicker\"]/android.view.ViewGroup")
    public WebElement wheelPicker;





}
