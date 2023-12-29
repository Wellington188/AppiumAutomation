import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class VerticalSwipingPage extends Comandos {

    public VerticalSwipingPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"listview\"]/android.view.ViewGroup")
    public RemoteWebElement listScreen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Back\"]")
    public WebElement backButton;


    public void getAllElements() {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'android.widget.TextView')]"));

        for (WebElement element : list) {
            do {
                System.out.println(element.getText());
            }while (list.size()>0);
        }
    }
}