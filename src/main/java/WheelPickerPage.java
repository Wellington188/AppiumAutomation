import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class WheelPickerPage extends Comandos{

    public WheelPickerPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    List<String> textColorExpected = Arrays.asList("red", "green ", "blue ", "black ");

    @AndroidFindBy(xpath = "//*[contains(@class, 'android.widget.TextView')]")
    public WebElement upCurrentColor;

    @AndroidFindBy(className = "android.widget.Spinner")
    public WebElement picker;

    public WebElement insertListIndex(String color){
        String element = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+color+"\"]";
        WebElement element1 = driver.findElement(By.xpath(element));
        return element1;
    }

}
